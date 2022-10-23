package com.example.BankOnlineApp.services;

import com.example.BankOnlineApp.entities.Money;
import com.example.BankOnlineApp.entities.Transaction;
import com.example.BankOnlineApp.entities.account.Account;
import com.example.BankOnlineApp.entities.account.CheckingAccount;
import com.example.BankOnlineApp.entities.account.CreditCard;
import com.example.BankOnlineApp.entities.account.Savings;
import com.example.BankOnlineApp.entities.user.AccountHolder;
import com.example.BankOnlineApp.repositories.AccountRepository;
import com.example.BankOnlineApp.repositories.TransactionRepository;
import com.example.BankOnlineApp.services.serviceInterfaces.AccountHolderServiceInterface;
import com.example.BankOnlineApp.repositories.AccountHolderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.util.List;

import static com.example.BankOnlineApp.entities.account.Savings.secretKey;

@Service
public abstract class AccountHolderService implements AccountHolderServiceInterface {

    @Autowired
    AccountHolderRepository accountHolderRepository;

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    TransactionRepository transactionRepository;
    private Money money;
    private Object owner;
    private AccountHolder secondaryOwner;
    private Money creationDate;


    //register new accountHolder
    public AccountHolder registerAccountHolder(AccountHolder accountHolder){
        return accountHolderRepository.save(accountHolder);
    }

public List<Account> getAccountHolderAccount(Long userId){
        AccountHolder accountHolder = accountHolderRepository.findById(userId).get();
        List<Account> accountHolderList = accountRepository.findByPrimaryOwner(accountHolder);
        List<Account> accountHolderList1 = accountRepository.findBySecondaryOwner(accountHolder);
        accountHolderList.addAll(accountHolderList1);
        return accountHolderList;
}

    //access balance
public BigDecimal getBalance(Long idAccountNumber){
    Account account = accountRepository.findById(idAccountNumber).get();
    if(account instanceof CreditCard){
        ((CreditCard) account).getInterestRate();
    } else if(account instanceof Savings){
        ((Savings) account).checkInterestRate();
    }

    return account.getBalance().getAmount();
}

    //transfer amount of money
    public void transferAmount(String ownerName, Long ownerId, Money transactionAmount) {

        Account receiverAccount;
        AccountHolder receiverHolder;

        if (accountRepository.findById(ownerId).isPresent()) {
            receiverAccount = accountRepository.findById(ownerId).get();

        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "The ID of the account is not in our systems");
        }

        if (receiverAccount.getPrimaryOwner().getUsername().matches(ownerName) || receiverAccount.getSecondaryOwner().getUsername().matches(ownerName)) {


            Account senderAccount = new CheckingAccount(money, secretKey, owner, secondaryOwner, creationDate);

            receiverHolder = receiverAccount.getPrimaryOwner();



            if (senderAccount.getMoney().getAmount().compareTo(transactionAmount.getAmount()) < 0) {
                throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, "Not enough funds in your account");
            } else {

                BigDecimal amountSent = transactionAmount.moneyConversionEur();
                BigDecimal senderBalance = senderAccount.getMoney().moneyConversionEur();
                BigDecimal receiverBalance = receiverAccount.getMoney().moneyConversionEur();

                BigDecimal senderFinal = senderBalance.subtract(amountSent);
                BigDecimal receiverFinal = receiverBalance.add(amountSent);


                Money resultSender = senderAccount.getMoney();
                Money resultReceiver = receiverAccount.getMoney();

                resultSender.setAmount(senderFinal);
                resultSender.conversionToAccount();

                resultReceiver.setAmount(receiverFinal);
                resultReceiver.conversionToAccount();

                senderAccount.setMoney(resultSender);
                receiverAccount.setMoney(resultReceiver);

                if (senderAccount.getClass().equals(CheckingAccount.class)) {
                    if (senderAccount.getMoney().getAmount().compareTo(((CheckingAccount) senderAccount).getMinimumBalance().getAmount()) < 0) {
                        senderAccount.applyPenaltyFee();
                    }
                } else if (senderAccount.getClass().equals(Savings.class)){
                    if (senderAccount.getMoney().getAmount().compareTo(((Savings) senderAccount).getMinimumBalance().getAmount()) < 0) {
                        senderAccount.applyPenaltyFee();
                    }
                }
                accountRepository.save(senderAccount);
                accountRepository.save(receiverAccount);

                Transaction transaction = new Transaction(senderAccount.getPrimaryOwner(), receiverAccount.getPrimaryOwner());
                transactionRepository.save(transaction);
            }
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The name of the client introduced doesn't match");
        }
    }
}


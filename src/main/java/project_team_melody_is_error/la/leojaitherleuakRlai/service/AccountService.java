package project_team_melody_is_error.la.leojaitherleuakRlai.service;

import aj.org.objectweb.asm.ConstantDynamic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import project_team_melody_is_error.la.leojaitherleuakRlai.entity.Account;
import project_team_melody_is_error.la.leojaitherleuakRlai.model.AccountModel;
import project_team_melody_is_error.la.leojaitherleuakRlai.repository.AccountRepository;

import java.time.LocalDateTime;
import java.util.*;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

//    public Account getAccountById(Long id) {
//        return accountRepository.findById(id).orElseThrow(() -> new RuntimeException("Account not found."));
//    }


    private List<AccountModel> accounts;
    private ConstantDynamic profile;

    public AccountService() {
        this.accounts = new ArrayList<>();
    }

//    public String addAccount(AccountModel account) {
//// บันทึกบัญชีใหม่เข้าสู่ระบบด้วยเมธอดที่เหมาะสมในคลาส Repository หรือ Data Access Object (DAO)
//        Account newAccount = new Account();
//        newAccount.setId(account.getId());
//        newAccount.setEmail(account.getEmail());
//        newAccount.setFirstname(account.getFirstname());
//        newAccount.setLastname(account.getLastname());
//        newAccount.setBirthday(account.getBirthday());
//        newAccount.setDatetime(account.getDatetime());
//        accountRepository.save(newAccount);
//        if (newAccount.getId() != null) {
//            return "success";
//        } else {
//            return "unsuccess";
//        }
//    }


//_________________________________________CREATE ACCOUNT__________________________________________________________
    public ResponseEntity<?> getGmailEntity(AccountModel accountModel) {
        Account gmail = this.accountRepository.findByEmail(accountModel.getEmail());
        if(gmail == null){
            Account gm = new Account();
            gm.setId(accountModel.getId());
            gm.setEmail(accountModel.getEmail());
            gm.setFirstname(accountModel.getFirstname());
            gm.setLastname(accountModel.getLastname());
            gm.setBirthday(accountModel.getBirthday());
            gm.setImageUrl(accountModel.getImageUrl());
            gm.setDatetime(LocalDateTime.now());
            this.accountRepository.save(gm);
            return  ResponseEntity.status(HttpStatus.OK).body("Login success saved");
        } else {
            return ResponseEntity.status(HttpStatus.OK).body("Login successful");
        }
    }

//______________________________________________________________________________________________________________________


//_____________________________________________GET ALL ACCOUNT__________________________________________________________

    public List<AccountModel> findAllAccount() {
        List<Account> dataList = this.accountRepository.findAll();
        List<AccountModel> result = new ArrayList<>();
        for (Account account : dataList) {
            AccountModel model = new AccountModel();
            model.setId(account.getId());
            model.setEmail(account.getEmail());
            model.setFirstname(account.getFirstname());
            model.setLastname(account.getLastname());
            model.setBirthday(account.getBirthday());
            model.setDatetime(account.getDatetime());
            model.setImageUrl(account.getImageUrl());
            result.add(model);
        }
        return result;
    }

//______________________________________________________________________________________________________________________


//_____________________________________________GET ONE ID ACCOUNT__________________________________________________________

    public AccountModel findAccountById(Long id) {
        Optional<Account> optionalAccount = accountRepository.findById(id);
        if (optionalAccount.isPresent()) {
            Account account = optionalAccount.get();
            AccountModel model = new AccountModel();
            model.setId(account.getId());
            model.setEmail(account.getEmail());
            model.setFirstname(account.getFirstname());
            model.setLastname(account.getLastname());
            model.setBirthday(account.getBirthday());
            model.setDatetime(account.getDatetime());
            model.setImageUrl(account.getImageUrl());
            return model;
        } else {
            throw new RuntimeException("Account not found with id " + id);
        }
    }

//______________________________________________________________________________________________________________________



//_____________________________________________GET ALL ACCOUNT__________________________________________________________



//______________________________________________________________________________________________________________________



//_____________________________________________GET ALL ACCOUNT__________________________________________________________



//______________________________________________________________________________________________________________________


}


package project_team_melody_is_error.la.leojaitherleuakRlai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;
import project_team_melody_is_error.la.leojaitherleuakRlai.entity.Account;
import project_team_melody_is_error.la.leojaitherleuakRlai.model.AccountModel;
import project_team_melody_is_error.la.leojaitherleuakRlai.repository.AccountRepository;
import project_team_melody_is_error.la.leojaitherleuakRlai.service.AccountService;

import java.util.List;
import java.util.Map;
@RestController
@RequestMapping("/api")
public class AccountController {
    @Autowired
    private AccountService accountService;
    private AccountRepository accountRepository;


    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }


//_____________________________________________create ACCOUNT__________________________________________________________

    @PostMapping("/login/gmail")
    public ResponseEntity<?> loginWithGmail(@RequestBody AccountModel accountModel) {
        return accountService.getGmailEntity(accountModel);
    }

//______________________________________________________________________________________________________________________


//_____________________________________________GET ALL ACCOUNT__________________________________________________________

    @GetMapping("/all/account")
    public ResponseEntity<List<AccountModel>> findAllAccounts() {
        List<AccountModel> accounts = accountService.findAllAccount();
        return ResponseEntity.ok().body(accounts);
    }

//______________________________________________________________________________________________________________________


//_____________________________________________GET ONE ID ACCOUNT__________________________________________________________

    @GetMapping("/all/account/{id}")
    public ResponseEntity<AccountModel> findAccountById(@PathVariable Long id) {
        AccountModel account = accountService.findAccountById(id);
        return ResponseEntity.ok().body(account);
    }

//______________________________________________________________________________________________________________________




}









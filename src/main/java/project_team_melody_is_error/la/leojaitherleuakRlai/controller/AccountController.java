package project_team_melody_is_error.la.leojaitherleuakRlai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import project_team_melody_is_error.la.leojaitherleuakRlai.entity.Account;
import project_team_melody_is_error.la.leojaitherleuakRlai.model.AccountModel;
import project_team_melody_is_error.la.leojaitherleuakRlai.repository.AccountRepository;
import project_team_melody_is_error.la.leojaitherleuakRlai.service.AccountService;

import java.util.List;
import java.util.Map;
@RestController
@RequestMapping("/login")
public class AccountController {
    @Autowired
    private AccountService accountService;
    private AccountRepository accountRepository;


    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping
    public List<AccountModel> getAllAccounts() {
        return accountService.getAllAccounts();
    }

    @GetMapping("/{id}")
    public AccountModel getAccountById(@PathVariable Long id) {
        return accountService.getAccountById(id);
    }

    @GetMapping("/email/{email}")
    public List<AccountModel> getAccountsByEmail(@PathVariable String email) {
        return accountService.getAccountsByEmail(email);
    }



    @PostMapping("/accounts")
    public ResponseEntity<String> addAccount(@RequestBody AccountModel account) {
        String result = accountService.addAccount(account);
        return ResponseEntity.ok(result);
    }



    @DeleteMapping("/{id}")
    public void removeAccount(@PathVariable Long id) {
        AccountModel account = accountService.getAccountById(id);
        if (account != null) {
            accountService.removeAccount(account);
        }
    }

    // เพิ่มเมทอดอื่น ๆ เช่นอัพเดทข้อมูลบัญชี ตามความต้องการของคุณ

}






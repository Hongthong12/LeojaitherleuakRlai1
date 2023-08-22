package project_team_melody_is_error.la.leojaitherleuakRlai.service;

import aj.org.objectweb.asm.ConstantDynamic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project_team_melody_is_error.la.leojaitherleuakRlai.entity.Account;
import project_team_melody_is_error.la.leojaitherleuakRlai.model.AccountModel;
import project_team_melody_is_error.la.leojaitherleuakRlai.repository.AccountRepository;

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

    public String addAccount(AccountModel account) {
        // ทำความสะอาดข้อมูล
        // ตรวจสอบความถูกต้องของข้อมูล
        // ใช้ access token ของ google ในการดึงข้อมูลผู้ใช้จาก google api
//        GoogleCredential credential = new GoogleCredential().setAccessToken(account.getAccessToken());
//        Plus plus = new Plus.Builder(new NetHttpTransport(), new JacksonFactory(), credential)
//                .setApplicationName("Google-PlusSample/1.0").build();
//        Person profile = plus.people().get("me").execute();

        // กำหนดค่าให้กับ AccountModel


//        account.setEmail(profile.getEmail().get(0).getValue());
//        account.setFirstname(profile.getName().getGivenName());
//        account.setLastname(profile.getName().getFamilyName());
//
//
//        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
//        Date date = formatter.parse(profile.getBirthday());
//        LocalDate birthday = new java.sql.Date(date.getTime()).toLocalDate();
//        account.setBirthday(birthday);
//
//        account.setDatetime(LocalDateTime.now());
//        account.setAccessToken(account.getAccessToken());
//        account.setRefreshToken(account.getRefreshToken());
//        account.setExpiresAt(account.getExpiresAt());

        // บันทึกบัญชีใหม่เข้าสู่ระบบด้วยเมธอดที่เหมาะสมในคลาส Repository หรือ Data Access Object (DAO)
        Account newAccount = new Account();
        newAccount.setId(account.getId());
        newAccount.setEmail(account.getEmail());
        newAccount.setFirstname(account.getFirstname());
        newAccount.setLastname(account.getLastname());
        newAccount.setBirthday(account.getBirthday());
        newAccount.setDatetime(account.getDatetime());
        accountRepository.save(newAccount);
        if (newAccount.getId() != null) {
            return "success";
        } else {
            return "unsuccess";
        }
    }

    public void removeAccount(AccountModel account) {
        accounts.remove(account);
    }

    public List<AccountModel> getAllAccounts() {
        return accounts;
    }

    public AccountModel getAccountById(Long id) {
        for (AccountModel account : accounts) {
            if (account.getId().equals(id)) {
                return account;
            }
        }
        return null;
    }

    public List<AccountModel> getAccountsByEmail(String email) {
        List<AccountModel> result = new ArrayList<>();
        for (AccountModel account : accounts) {
            if (account.getEmail().equals(email)) {
                result.add(account);
            }
        }
        return result;
    }

    public void updateAccount(AccountModel account) {
        Account existingAccount = accountRepository.findById(account.getId()).orElse(null);
        if (existingAccount != null) {
            existingAccount.setEmail(account.getEmail());
            existingAccount.setFirstname(account.getFirstname());
            existingAccount.setLastname(account.getLastname());
            existingAccount.setBirthday(account.getBirthday());
            existingAccount.setDatetime(account.getDatetime());
            accountRepository.save(existingAccount);
        }
    }

    public boolean isAccountExists(AccountModel account) {
        Account existingAccount = accountRepository.findByEmail(account.getEmail());
        if (existingAccount != null) {
            return true;
        }
        return false;
    }

    public boolean isAccountExistsByEmail(String email) {
        Account existingAccount = accountRepository.findByEmail(email);
        if (existingAccount != null) {
            return true;
        }
        return false;
    }
        // เพิ่มเมธอดอื่น ๆ เช่น อัพเดทข้อมูลบัญชี หรือตรวจสอบการเข้าสู่ระบบ ตามความต้องการของคุณ


}


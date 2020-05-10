package com.example.iste_satin_al.Models;

import java.io.Serializable;

public class Firma implements Serializable {
 private int     CompanyMembersId;
   private String  CompanyMembersName;
    private String CompanyMembersSurname;
    private String CompanyMembersNickname;
    private String CompanyMembersPassword;
    private String CompanyMembersEmail;
    private String  CompanyMembersPhone;
    private String CompanyName;
    private String CompanyId;
    private String CompanyPhone;
    private String CompanyType;

    public Firma() {
    }

    public Firma(int companyMembersId, String companyMembersName, String companyMembersSurname,
                 String companyMembersNickname, String companyMembersPassword, String companyMembersEmail,
                 String companyMembersPhone, String companyName, String companyId, String companyPhone, String companyType) {
        CompanyMembersId = companyMembersId;
        CompanyMembersName = companyMembersName;
        CompanyMembersSurname = companyMembersSurname;
        CompanyMembersNickname = companyMembersNickname;
        CompanyMembersPassword = companyMembersPassword;
        CompanyMembersEmail = companyMembersEmail;
        CompanyMembersPhone = companyMembersPhone;
        CompanyName = companyName;
        CompanyId = companyId;
        CompanyPhone = companyPhone;
        CompanyType = companyType;
    }

    public int getCompanyMembersId() {
        return CompanyMembersId;
    }

    public void setCompanyMembersId(int companyMembersId) {
        CompanyMembersId = companyMembersId;
    }

    public String getCompanyMembersName() {
        return CompanyMembersName;
    }

    public void setCompanyMembersName(String companyMembersName) {
        CompanyMembersName = companyMembersName;
    }

    public String getCompanyMembersSurname() {
        return CompanyMembersSurname;
    }

    public void setCompanyMembersSurname(String companyMembersSurname) {
        CompanyMembersSurname = companyMembersSurname;
    }

    public String getCompanyMembersNickname() {
        return CompanyMembersNickname;
    }

    public void setCompanyMembersNickname(String companyMembersNickname) {
        CompanyMembersNickname = companyMembersNickname;
    }

    public String getCompanyMembersPassword() {
        return CompanyMembersPassword;
    }

    public void setCompanyMembersPassword(String companyMembersPassword) {
        CompanyMembersPassword = companyMembersPassword;
    }

    public String getCompanyMembersEmail() {
        return CompanyMembersEmail;
    }

    public void setCompanyMembersEmail(String companyMembersEmail) {
        CompanyMembersEmail = companyMembersEmail;
    }

    public String getCompanyMembersPhone() {
        return CompanyMembersPhone;
    }

    public void setCompanyMembersPhone(String companyMembersPhone) {
        CompanyMembersPhone = companyMembersPhone;
    }

    public String getCompanyName() {
        return CompanyName;
    }

    public void setCompanyName(String companyName) {
        CompanyName = companyName;
    }

    public String getCompanyId() {
        return CompanyId;
    }

    public void setCompanyId(String companyId) {
        CompanyId = companyId;
    }

    public String getCompanyPhone() {
        return CompanyPhone;
    }

    public void setCompanyPhone(String companyPhone) {
        CompanyPhone = companyPhone;
    }

    public String getCompanyType() {
        return CompanyType;
    }

    public void setCompanyType(String companyType) {
        CompanyType = companyType;
    }
}

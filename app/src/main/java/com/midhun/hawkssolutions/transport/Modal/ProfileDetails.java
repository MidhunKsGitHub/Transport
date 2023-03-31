package com.midhun.hawkssolutions.transport.Modal;

import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

@Entity(tableName = "Profile", indices = @Index(value = {"id"}, unique = true))
public class ProfileDetails {

    @PrimaryKey(autoGenerate = true)
    private int uid;
    private String id;
    private String company_id;
    private String employee_code;
    private String employment_type;
    private String name;
    private String image;
    private String designation;
    private String employee_type;
    private String contact;
    private String email;
    private String address;
    private String doj;
    @SerializedName("package")
    private String mypackage;
    private String hra;
    private String da;
    private String ta;
    private String fa;
    private String ot;
    private String bonus;
    private String adhaar_no;
    private String pan_no;
    private String driving_license;
    private String driving_license_expiry;
    private String status;
    private String delete_status;
    private String created_at;
    private String created_by;
    private String updated_at;
    private String updated_by;
    private String deleted_by;
    private String deleted_at;
    private String employeeType;


    public ProfileDetails(String id, String company_id, String employee_code, String employment_type, String name, String image, String designation, String employee_type, String contact, String email, String address, String doj, String mypackage, String hra, String da, String ta, String fa, String ot, String bonus, String adhaar_no, String pan_no, String driving_license, String driving_license_expiry, String status, String delete_status, String created_at, String created_by, String updated_at, String updated_by, String deleted_by, String deleted_at, String employeeType) {
        this.id = id;
        this.company_id = company_id;
        this.employee_code = employee_code;
        this.employment_type = employment_type;
        this.name = name;
        this.image = image;
        this.designation = designation;
        this.employee_type = employee_type;
        this.contact = contact;
        this.email = email;
        this.address = address;
        this.doj = doj;
        this.mypackage = mypackage;
        this.hra = hra;
        this.da = da;
        this.ta = ta;
        this.fa = fa;
        this.ot = ot;
        this.bonus = bonus;
        this.adhaar_no = adhaar_no;
        this.pan_no = pan_no;
        this.driving_license = driving_license;
        this.driving_license_expiry = driving_license_expiry;
        this.status = status;
        this.delete_status = delete_status;
        this.created_at = created_at;
        this.created_by = created_by;
        this.updated_at = updated_at;
        this.updated_by = updated_by;
        this.deleted_by = deleted_by;
        this.deleted_at = deleted_at;
        this.employeeType = employeeType;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCompany_id() {
        return company_id;
    }

    public void setCompany_id(String company_id) {
        this.company_id = company_id;
    }

    public String getEmployee_code() {
        return employee_code;
    }

    public void setEmployee_code(String employee_code) {
        this.employee_code = employee_code;
    }

    public String getEmployment_type() {
        return employment_type;
    }

    public void setEmployment_type(String employment_type) {
        this.employment_type = employment_type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getEmployee_type() {
        return employee_type;
    }

    public void setEmployee_type(String employee_type) {
        this.employee_type = employee_type;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDoj() {
        return doj;
    }

    public void setDoj(String doj) {
        this.doj = doj;
    }

    public String getMypackage() {
        return mypackage;
    }

    public void setMypackage(String mypackage) {
        this.mypackage = mypackage;
    }

    public String getHra() {
        return hra;
    }

    public void setHra(String hra) {
        this.hra = hra;
    }

    public String getDa() {
        return da;
    }

    public void setDa(String da) {
        this.da = da;
    }

    public String getTa() {
        return ta;
    }

    public void setTa(String ta) {
        this.ta = ta;
    }

    public String getFa() {
        return fa;
    }

    public void setFa(String fa) {
        this.fa = fa;
    }

    public String getOt() {
        return ot;
    }

    public void setOt(String ot) {
        this.ot = ot;
    }

    public String getBonus() {
        return bonus;
    }

    public void setBonus(String bonus) {
        this.bonus = bonus;
    }

    public String getAdhaar_no() {
        return adhaar_no;
    }

    public void setAdhaar_no(String adhaar_no) {
        this.adhaar_no = adhaar_no;
    }

    public String getPan_no() {
        return pan_no;
    }

    public void setPan_no(String pan_no) {
        this.pan_no = pan_no;
    }

    public String getDriving_license() {
        return driving_license;
    }

    public void setDriving_license(String driving_license) {
        this.driving_license = driving_license;
    }

    public String getDriving_license_expiry() {
        return driving_license_expiry;
    }

    public void setDriving_license_expiry(String driving_license_expiry) {
        this.driving_license_expiry = driving_license_expiry;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDelete_status() {
        return delete_status;
    }

    public void setDelete_status(String delete_status) {
        this.delete_status = delete_status;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getCreated_by() {
        return created_by;
    }

    public void setCreated_by(String created_by) {
        this.created_by = created_by;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public String getUpdated_by() {
        return updated_by;
    }

    public void setUpdated_by(String updated_by) {
        this.updated_by = updated_by;
    }

    public String getDeleted_by() {
        return deleted_by;
    }

    public void setDeleted_by(String deleted_by) {
        this.deleted_by = deleted_by;
    }

    public String getDeleted_at() {
        return deleted_at;
    }

    public void setDeleted_at(String deleted_at) {
        this.deleted_at = deleted_at;
    }

    public String getEmployeeType() {
        return employeeType;
    }

    public void setEmployeeType(String employeeType) {
        this.employeeType = employeeType;
    }
}

package com.midhun.hawkssolutions.transport.Modal;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(tableName = "LoginTable", indices = @Index(value = {"id"},unique = true))

public class Login {

    @PrimaryKey(autoGenerate = true)
    private  int UID;

    public int getUID() {
        return UID;
    }

    public void setUID(int UID) {
        this.UID = UID;
    }

    private String id;
    private String company_id;

    public String getId() {
        return id;
    }

    public Login(String id, String company_id, String username, String password, String name, String user_type, String created_by, String created_at, String updated_at, String updated_by, String deleted_at, String deleted_by, String firebase_token, String status, String delete_status, String rememberme,String error) {
        this.id = id;
        this.company_id = company_id;
        this.username = username;
        this.password = password;
        this.name = name;
        this.user_type = user_type;
        this.created_by = created_by;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.updated_by = updated_by;
        this.deleted_at = deleted_at;
        this.deleted_by = deleted_by;
        this.firebase_token = firebase_token;
        this.status = status;
        this.delete_status = delete_status;
        this.rememberme = rememberme;
        this.error=error;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUser_type() {
        return user_type;
    }

    public void setUser_type(String user_type) {
        this.user_type = user_type;
    }

    public String getCreated_by() {
        return created_by;
    }

    public void setCreated_by(String created_by) {
        this.created_by = created_by;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
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

    public String getDeleted_at() {
        return deleted_at;
    }

    public void setDeleted_at(String deleted_at) {
        this.deleted_at = deleted_at;
    }

    public String getDeleted_by() {
        return deleted_by;
    }

    public void setDeleted_by(String deleted_by) {
        this.deleted_by = deleted_by;
    }

    public String getFirebase_token() {
        return firebase_token;
    }

    public void setFirebase_token(String firebase_token) {
        this.firebase_token = firebase_token;
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

    public String getRememberme() {
        return rememberme;
    }

    public void setRememberme(String rememberme) {
        this.rememberme = rememberme;
    }
    @ColumnInfo(name = "username")
    private String username;
    private String password;
    private String name;
    private String user_type;
    private String created_by;
    private String created_at;
    private String updated_at;
    private String updated_by;
    private String deleted_at;
    private String deleted_by;
    private String firebase_token;
    private String status;
    private String delete_status;
    private String rememberme;

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    private String error;
}

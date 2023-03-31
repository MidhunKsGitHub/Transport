package com.midhun.hawkssolutions.transport.Modal;

import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(tableName = "ExpenseType",indices = @Index(value = {"id"},unique = true))
public class ExpenseType {

    @PrimaryKey(autoGenerate = true)
    private int uid;
    private String id;
    private String head;
    private String type;
    private String status;
    private String delete_status;
    private String created_by;
    private String created_at;
    private String updated_by;
    private String updated_at;
    private String deleted_at;
    private String deleted_by;

    public ExpenseType(String id, String head, String type, String status, String delete_status, String created_by, String created_at, String updated_by, String updated_at, String deleted_at, String deleted_by) {
        this.id = id;
        this.head = head;
        this.type = type;
        this.status = status;
        this.delete_status = delete_status;
        this.created_by = created_by;
        this.created_at = created_at;
        this.updated_by = updated_by;
        this.updated_at = updated_at;
        this.deleted_at = deleted_at;
        this.deleted_by = deleted_by;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public String getUpdated_by() {
        return updated_by;
    }

    public void setUpdated_by(String updated_by) {
        this.updated_by = updated_by;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
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

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }
}

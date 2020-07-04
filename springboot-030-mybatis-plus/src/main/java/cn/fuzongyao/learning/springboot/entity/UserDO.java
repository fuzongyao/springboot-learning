package cn.fuzongyao.learning.springboot.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * <p>
 * user table
 * </p>
 *
 * @author fuzongyao
 * @since 2018-10-22
 */
@TableName("sys_user")
@ApiModel(value = "UserDO", description = "UserDO")
public class UserDO extends Model<UserDO> {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty(name = "id", value = "id")
    private Long id;
    /**
     * create time
     */
    @TableField(value = "gmt_create", fill = FieldFill.INSERT)
    @ApiModelProperty(name = "gmtCreate", value = "create time")
    private LocalDateTime gmtCreate;
    /**
     * last modified time
     */
    @TableField(value = "gmt_modified", fill = FieldFill.INSERT_UPDATE)
    @ApiModelProperty(name = "gmtModified", value = "last modified time")
    private LocalDateTime gmtModified;
    /**
     * is deleted,0:not delete;1:deleted.
     */
    @TableField("is_deleted")
    @TableLogic
    @ApiModelProperty(name = "deleted", value = "is deleted,0:not delete;1:deleted.")
    private Boolean deleted;
    /**
     * creater
     */
    @ApiModelProperty(name = "creater", value = "creater")
    private Long creater;
    /**
     * user type,1:doctor,2:pharmacist;3:patient
     */
    @ApiModelProperty(name = "type", value = "user type,1:doctor,2:pharmacist;3:patient")
    private Integer type;
    /**
     * phone
     */
    @ApiModelProperty(name = "phone", value = "phone")
    private String phone;
    /**
     * password
     */
    @ApiModelProperty(name = "password", value = "password")
    private String password;
    /**
     * login number
     */
    @TableField("login_num")
    @ApiModelProperty(name = "loginNum", value = "login number")
    private Integer loginNum;
    /**
     * last login time
     */
    @TableField("last_login_time")
    @ApiModelProperty(name = "lastLoginTime", value = "last login time")
    private LocalDateTime lastLoginTime;
    /**
     * is audited,0:has not audited;1:pass audit;3:not pass audit
     */
    @ApiModelProperty(name = "status", value = "is audited,0:has not audited;1:pass audit;3:not pass audit")
    private Integer status;
    /**
     * imei
     */
    @ApiModelProperty(name = "imei", value = "imei")
    private String imei;
    /**
     * district_id
     */
    @TableField("district_id")
    @ApiModelProperty(name = "districtId", value = "district_id")
    private Long districtId;
    /**
     * address
     */
    @ApiModelProperty(name = "address", value = "address")
    private String address;

    /**
     * clinicName
     */
    @ApiModelProperty(name = "clinicName", value = "clinicName")
    private String clinicName;

    /**
     * name
     */
    @ApiModelProperty(name = "name", value = "name")
    private String name;
    /**
     * user gender,0:other;1:male,2:female
     */
    @ApiModelProperty(name = "gender", value = "user gender,0:other;1:male,2:female")
    private Integer gender;
    /**
     * birthday
     */
    @ApiModelProperty(name = "birthday", value = "birthday")
    private LocalDate birthday;
    /**
     * client source, 0:default; 1: android; 2: ios;
     */
    @TableField("client_source")
    @ApiModelProperty(name = "clientSource", value = "client source, 0:default; 1: android; 2: ios;")
    private Integer clientSource;
    /**
     * IC card no
     */
    @TableField("ic_no")
    @ApiModelProperty(name = "icNo", value = "IC card no")
    private String icNo;

    /**
     * fireBase cloud massage token
     */
    @TableField("fcm_token")
    @ApiModelProperty(name = "fcmTaken", value = "fireBase cloud massage token")
    private String fcmToken;


    public Long getId() {
        return id;
    }

    public UserDO setId(Long id) {
        this.id = id;
        return this;
    }

    public LocalDateTime getGmtCreate() {
        return gmtCreate;
    }

    public UserDO setGmtCreate(LocalDateTime gmtCreate) {
        this.gmtCreate = gmtCreate;
        return this;
    }

    public LocalDateTime getGmtModified() {
        return gmtModified;
    }

    public UserDO setGmtModified(LocalDateTime gmtModified) {
        this.gmtModified = gmtModified;
        return this;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public UserDO setDeleted(Boolean deleted) {
        this.deleted = deleted;
        return this;
    }

    public Long getCreater() {
        return creater;
    }

    public UserDO setCreater(Long creater) {
        this.creater = creater;
        return this;
    }

    public Integer getType() {
        return type;
    }

    public UserDO setType(Integer type) {
        this.type = type;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public UserDO setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserDO setPassword(String password) {
        this.password = password;
        return this;
    }

    public Integer getLoginNum() {
        return loginNum;
    }

    public UserDO setLoginNum(Integer loginNum) {
        this.loginNum = loginNum;
        return this;
    }

    public LocalDateTime getLastLoginTime() {
        return lastLoginTime;
    }

    public UserDO setLastLoginTime(LocalDateTime lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
        return this;
    }

    public Integer getStatus() {
        return status;
    }

    public UserDO setStatus(Integer status) {
        this.status = status;
        return this;
    }

    public String getImei() {
        return imei;
    }

    public UserDO setImei(String imei) {
        this.imei = imei;
        return this;
    }

    public Long getDistrictId() {
        return districtId;
    }

    public UserDO setDistrictId(Long districtId) {
        this.districtId = districtId;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public UserDO setAddress(String address) {
        this.address = address;
        return this;
    }

    public String getClinicName() {
        return clinicName;
    }

    public void setClinicName(String clinicName) {
        this.clinicName = clinicName;
    }

    public String getName() {
        return name;
    }

    public UserDO setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getGender() {
        return gender;
    }

    public UserDO setGender(Integer gender) {
        this.gender = gender;
        return this;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public UserDO setBirthday(LocalDate birthday) {
        this.birthday = birthday;
        return this;
    }

    public Integer getClientSource() {
        return clientSource;
    }

    public UserDO setClientSource(Integer clientSource) {
        this.clientSource = clientSource;
        return this;
    }

    public String getIcNo() {
        return icNo;
    }

    public UserDO setIcNo(String icNo) {
        this.icNo = icNo;
        return this;
    }

    public String getFcmToken() {
        return fcmToken;
    }

    public void setFcmToken(String fcmToken) {
        this.fcmToken = fcmToken;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "UserDO{" +
                "id=" + id +
                ", gmtCreate=" + gmtCreate +
                ", gmtModified=" + gmtModified +
                ", deleted=" + deleted +
                ", creater=" + creater +
                ", type=" + type +
                ", phone='" + phone + '\'' +
                ", password='" + password + '\'' +
                ", loginNum=" + loginNum +
                ", lastLoginTime=" + lastLoginTime +
                ", status=" + status +
                ", imei='" + imei + '\'' +
                ", districtId=" + districtId +
                ", address='" + address + '\'' +
                ", clinicName='" + clinicName + '\'' +
                ", name='" + name + '\'' +
                ", gender=" + gender +
                ", birthday=" + birthday +
                ", clientSource=" + clientSource +
                ", icNo='" + icNo + '\'' +
                ", fcmToken='" + fcmToken + '\'' +
                '}';
    }
}

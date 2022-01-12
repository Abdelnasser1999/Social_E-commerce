package com.nasser.ma99.social_e_commerce.Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;

public class campaignModel implements Serializable {
    private String Companyid;
    private String userid;
    private String imagecomp;
    private String imagebrand;
    private String brandname;
    private String branddiscripe;
    private String catagorie;
    private String urlbarnd;
    private String copmname;
    private String coptype;
    private String copdescription;
    private String calltoaction;
    private String platforms;
    private String prelaoded;
    private String moodboard;
    private String Do;
    private String dont;
    private String attachmentdiscripe;
    private String age;
    private int price;
    private String influencertype;
    private String gender;
    private String targetcontry;
    private String intrest;
    private String paymenttype;
    private String publishdate;
    private String enddate;
    private String firstnamemaneger;
    private String lastnamemaneger;
    private String emailmaneger;
    private String mobilemanegernumber;
    private String companyname;
    private String vat;
    private String cr;
    private String FinancialEmail;
    private String financialphone;
    private String streetadress;
    private String city;
    private String wilaya;
    private String zip;


    public campaignModel() {

    }

    public campaignModel(String companyid, String userid, String imagecomp, String imagebrand, String brandname, String branddiscripe, String catagorie, String urlbarnd, String copmname, String coptype, String copdescription, String calltoaction, String platforms, String prelaoded, String moodboard, String aDo, String dont, String attachmentdiscripe, String age, int price, String influencertype, String gender, String targetcontry, String intrest, String paymenttype, String publishdate, String enddate, String firstnamemaneger, String lastnamemaneger, String emailmaneger, String mobilemanegernumber, String companyname, String vat, String cr, String financialEmail, String financialphone, String streetadress, String city, String wilaya, String zip) {
        Companyid = companyid;
        this.userid = userid;
        this.imagecomp = imagecomp;
        this.imagebrand = imagebrand;
        this.brandname = brandname;
        this.branddiscripe = branddiscripe;
        this.catagorie = catagorie;
        this.urlbarnd = urlbarnd;
        this.copmname = copmname;
        this.coptype = coptype;
        this.copdescription = copdescription;
        this.calltoaction = calltoaction;
        this.platforms = platforms;
        this.prelaoded = prelaoded;
        this.moodboard = moodboard;
        Do = aDo;
        this.dont = dont;
        this.attachmentdiscripe = attachmentdiscripe;
        this.age = age;
        this.price = price;
        this.influencertype = influencertype;
        this.gender = gender;
        this.targetcontry = targetcontry;
        this.intrest = intrest;
        this.paymenttype = paymenttype;
        this.publishdate = publishdate;
        this.enddate = enddate;
        this.firstnamemaneger = firstnamemaneger;
        this.lastnamemaneger = lastnamemaneger;
        this.emailmaneger = emailmaneger;
        this.mobilemanegernumber = mobilemanegernumber;
        this.companyname = companyname;
        this.vat = vat;
        this.cr = cr;
        FinancialEmail = financialEmail;
        this.financialphone = financialphone;
        this.streetadress = streetadress;
        this.city = city;
        this.wilaya = wilaya;
        this.zip = zip;
    }

    public void setPlatforms(String platforms) {
        this.platforms = platforms;
    }

    public String getCompanyid() {
        return Companyid;
    }

    public void setCompanyid(String companyid) {
        Companyid = companyid;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getImagecomp() {
        return imagecomp;
    }

    public void setImagecomp(String imagecomp) {
        this.imagecomp = imagecomp;
    }

    public String getImagebrand() {
        return imagebrand;
    }

    public void setImagebrand(String imagebrand) {
        this.imagebrand = imagebrand;
    }

    public String getBrandname() {
        return brandname;
    }

    public void setBrandname(String brandname) {
        this.brandname = brandname;
    }

    public String getBranddiscripe() {
        return branddiscripe;
    }

    public void setBranddiscripe(String branddiscripe) {
        this.branddiscripe = branddiscripe;
    }

    public String getCatagorie() {
        return catagorie;
    }

    public void setCatagorie(String catagorie) {
        this.catagorie = catagorie;
    }

    public String getUrlbarnd() {
        return urlbarnd;
    }

    public void setUrlbarnd(String urlbarnd) {
        this.urlbarnd = urlbarnd;
    }

    public String getCopmname() {
        return copmname;
    }

    public void setCopmname(String copmname) {
        this.copmname = copmname;
    }

    public String getCoptype() {
        return coptype;
    }

    public void setCoptype(String coptype) {
        this.coptype = coptype;
    }

    public String getCopdescription() {
        return copdescription;
    }

    public void setCopdescription(String copdescription) {
        this.copdescription = copdescription;
    }

    public String getCalltoaction() {
        return calltoaction;
    }

    public void setCalltoaction(String calltoaction) {
        this.calltoaction = calltoaction;
    }


    public String getPlatforms() {
        return platforms;
    }

    public String getPrelaoded() {
        return prelaoded;
    }

    public void setPrelaoded(String prelaoded) {
        this.prelaoded = prelaoded;
    }

    public String getMoodboard() {
        return moodboard;
    }

    public void setMoodboard(String moodboard) {
        this.moodboard = moodboard;
    }

    public String getDo() {
        return Do;
    }

    public void setDo(String aDo) {
        Do = aDo;
    }

    public String getDont() {
        return dont;
    }

    public void setDont(String dont) {
        this.dont = dont;
    }

    public String getAttachmentdiscripe() {
        return attachmentdiscripe;
    }

    public void setAttachmentdiscripe(String attachmentdiscripe) {
        this.attachmentdiscripe = attachmentdiscripe;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getInfluencertype() {
        return influencertype;
    }

    public void setInfluencertype(String influencertype) {
        this.influencertype = influencertype;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getTargetcontry() {
        return targetcontry;
    }

    public void setTargetcontry(String targetcontry) {
        this.targetcontry = targetcontry;
    }


    public String getIntrest() {
        return intrest;
    }

    public void setIntrest(String intrest) {
        this.intrest = intrest;
    }

    public String getPaymenttype() {
        return paymenttype;
    }

    public void setPaymenttype(String paymenttype) {
        this.paymenttype = paymenttype;
    }

    public String getPublishdate() {
        return publishdate;
    }

    public void setPublishdate(String publishdate) {
        this.publishdate = publishdate;
    }

    public String getEnddate() {
        return enddate;
    }

    public void setEnddate(String enddate) {
        this.enddate = enddate;
    }

    public String getFirstnamemaneger() {
        return firstnamemaneger;
    }

    public void setFirstnamemaneger(String firstnamemaneger) {
        this.firstnamemaneger = firstnamemaneger;
    }

    public String getLastnamemaneger() {
        return lastnamemaneger;
    }

    public void setLastnamemaneger(String lastnamemaneger) {
        this.lastnamemaneger = lastnamemaneger;
    }

    public String getEmailmaneger() {
        return emailmaneger;
    }

    public void setEmailmaneger(String emailmaneger) {
        this.emailmaneger = emailmaneger;
    }

    public String getMobilemanegernumber() {
        return mobilemanegernumber;
    }

    public void setMobilemanegernumber(String mobilemanegernumber) {
        this.mobilemanegernumber = mobilemanegernumber;
    }

    public String getCompanyname() {
        return companyname;
    }

    public void setCompanyname(String companyname) {
        this.companyname = companyname;
    }

    public String getVat() {
        return vat;
    }

    public void setVat(String vat) {
        this.vat = vat;
    }

    public String getCr() {
        return cr;
    }

    public void setCr(String cr) {
        this.cr = cr;
    }

    public String getFinancialEmail() {
        return FinancialEmail;
    }

    public void setFinancialEmail(String financialEmail) {
        FinancialEmail = financialEmail;
    }

    public String getFinancialphone() {
        return financialphone;
    }

    public void setFinancialphone(String financialphone) {
        this.financialphone = financialphone;
    }

    public String getStreetadress() {
        return streetadress;
    }

    public void setStreetadress(String streetadress) {
        this.streetadress = streetadress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getWilaya() {
        return wilaya;
    }

    public void setWilaya(String wilaya) {
        this.wilaya = wilaya;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }
}
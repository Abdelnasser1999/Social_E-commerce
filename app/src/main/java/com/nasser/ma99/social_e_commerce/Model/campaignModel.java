package com.nasser.ma99.social_e_commerce.Model;

import java.io.Serializable;
import java.util.Arrays;

public class campaignModel implements Serializable {
    private String HeaderImgUrl;
    private String LogoUrl;
    private String BrandName;
    private String BrandDescription;
    private String[] Categories;
    private String BrandLink;
    private String CompanyName;
    private String CompanyType;
    private String CompanyDescription;
    private String[] BrandPlatforms=new String[4];
    private String[] PreloadedContent;
    private String Do;
    private String Dont;
    private String[] Attachment;
    private String influencerAge;
    private int Price;
    private String influencerType;
    private String influencerGender;
    private String TargetRegion;
    private String influencerInterest;
    private String PaymentType;
    private String publishDate;
    private String EndDate;
    private String[] ManagerDetails =new String[3];
    private String[] FinancialDetails =new String[5];
    private String[] BillingAddress =new String[4];

    public campaignModel(String headerImgUrl, String logoUrl, String brandName, String brandDescription,
                         String[] categories, String brandLink, String companyName, String companyType,
                         String companyDescription, String[] brandPlatforms, String[] preloadedContent,
                         String aDo, String dont, String[] attachment, String influencerAge, int price,
                         String influencerType, String influencerGender, String targetRegion, String influencerInterest,
                         String paymentType, String publishDate, String endDate, String[] managerDetails,
                         String[] financialDetails, String[] billingAddress) {
        HeaderImgUrl = headerImgUrl;
        LogoUrl = logoUrl;
        BrandName = brandName;
        BrandDescription = brandDescription;
        Categories = categories;
        BrandLink = brandLink;
        CompanyName = companyName;
        CompanyType = companyType;
        CompanyDescription = companyDescription;
        BrandPlatforms = brandPlatforms;
        PreloadedContent = preloadedContent;
        Do = aDo;
        Dont = dont;
        Attachment = attachment;
        this.influencerAge = influencerAge;
        Price = price;
        this.influencerType = influencerType;
        this.influencerGender = influencerGender;
        TargetRegion = targetRegion;
        this.influencerInterest = influencerInterest;
        PaymentType = paymentType;
        this.publishDate = publishDate;
        EndDate = endDate;
        ManagerDetails = managerDetails;
        FinancialDetails = financialDetails;
        BillingAddress = billingAddress;
    }

    public campaignModel() {
    }

    public String getHeaderImgUrl() {
        return HeaderImgUrl;
    }

    public void setHeaderImgUrl(String headerImgUrl) {
        HeaderImgUrl = headerImgUrl;
    }

    public String getLogoUrl() {
        return LogoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        LogoUrl = logoUrl;
    }

    public String getBrandName() {
        return BrandName;
    }

    public void setBrandName(String brandName) {
        BrandName = brandName;
    }

    public String getBrandDescription() {
        return BrandDescription;
    }

    public void setBrandDescription(String brandDescription) {
        BrandDescription = brandDescription;
    }

    public String[] getCategories() {
        return Categories;
    }

    public void setCategories(String[] categories) {
        Categories = categories;
    }

    public String getBrandLink() {
        return BrandLink;
    }

    public void setBrandLink(String brandLink) {
        BrandLink = brandLink;
    }

    public String getCompanyName() {
        return CompanyName;
    }

    public void setCompanyName(String companyName) {
        CompanyName = companyName;
    }

    public String getCompanyType() {
        return CompanyType;
    }

    public void setCompanyType(String companyType) {
        CompanyType = companyType;
    }

    public String getCompanyDescription() {
        return CompanyDescription;
    }

    public void setCompanyDescription(String companyDescription) {
        CompanyDescription = companyDescription;
    }

    public String[] getBrandPlatforms() {
        return BrandPlatforms;
    }

    public void setBrandPlatforms(String[] brandPlatforms) {
        BrandPlatforms = brandPlatforms;
    }

    public String[] getPreloadedContent() {
        return PreloadedContent;
    }

    public void setPreloadedContent(String[] preloadedContent) {
        PreloadedContent = preloadedContent;
    }

    public String getDo() {
        return Do;
    }

    public void setDo(String aDo) {
        Do = aDo;
    }

    public String getDont() {
        return Dont;
    }

    public void setDont(String dont) {
        Dont = dont;
    }

    public String[] getAttachment() {
        return Attachment;
    }

    public void setAttachment(String[] attachment) {
        Attachment = attachment;
    }

    public String getInfluencerAge() {
        return influencerAge;
    }

    public void setInfluencerAge(String influencerAge) {
        this.influencerAge = influencerAge;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int price) {
        Price = price;
    }

    public String getInfluencerType() {
        return influencerType;
    }

    public void setInfluencerType(String influencerType) {
        this.influencerType = influencerType;
    }

    public String getInfluencerGender() {
        return influencerGender;
    }

    public void setInfluencerGender(String influencerGender) {
        this.influencerGender = influencerGender;
    }

    public String getTargetRegion() {
        return TargetRegion;
    }

    public void setTargetRegion(String targetRegion) {
        TargetRegion = targetRegion;
    }

    public String getInfluencerInterest() {
        return influencerInterest;
    }

    public void setInfluencerInterest(String influencerInterest) {
        this.influencerInterest = influencerInterest;
    }

    public String getPaymentType() {
        return PaymentType;
    }

    public void setPaymentType(String paymentType) {
        PaymentType = paymentType;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }

    public String getEndDate() {
        return EndDate;
    }

    public void setEndDate(String endDate) {
        EndDate = endDate;
    }

    public String[] getManagerDetails() {
        return ManagerDetails;
    }

    public void setManagerDetails(String[] managerDetails) {
        ManagerDetails = managerDetails;
    }

    public String[] getFinancialDetails() {
        return FinancialDetails;
    }

    public void setFinancialDetails(String[] financialDetails) {
        FinancialDetails = financialDetails;
    }

    public String[] getBillingAddress() {
        return BillingAddress;
    }

    public void setBillingAddress(String[] billingAddress) {
        BillingAddress = billingAddress;
    }

    @Override
    public String toString() {
        return "campaignModel{" +
                "HeaderImgUrl='" + HeaderImgUrl + '\'' +
                ", LogoUrl='" + LogoUrl + '\'' +
                ", BrandName='" + BrandName + '\'' +
                ", BrandDescription='" + BrandDescription + '\'' +
                ", Categories=" + Arrays.toString(Categories) +
                ", BrandLink='" + BrandLink + '\'' +
                ", CompanyName='" + CompanyName + '\'' +
                ", CompanyType='" + CompanyType + '\'' +
                ", CompanyDescription='" + CompanyDescription + '\'' +
                ", BrandPlatforms=" + Arrays.toString(BrandPlatforms) +
                ", PreloadedContent=" + Arrays.toString(PreloadedContent) +
                ", Do='" + Do + '\'' +
                ", Dont='" + Dont + '\'' +
                ", Attachment=" + Arrays.toString(Attachment) +
                ", influencerAge='" + influencerAge + '\'' +
                ", Price=" + Price +
                ", influencerType='" + influencerType + '\'' +
                ", influencerGender='" + influencerGender + '\'' +
                ", TargetRegion='" + TargetRegion + '\'' +
                ", influencerInterest='" + influencerInterest + '\'' +
                ", PaymentType='" + PaymentType + '\'' +
                ", publishDate='" + publishDate + '\'' +
                ", EndDate='" + EndDate + '\'' +
                ", ManagerDetails=" + Arrays.toString(ManagerDetails) +
                ", FinancialDetails=" + Arrays.toString(FinancialDetails) +
                ", BillingAddress=" + Arrays.toString(BillingAddress) +
                '}';
    }
}

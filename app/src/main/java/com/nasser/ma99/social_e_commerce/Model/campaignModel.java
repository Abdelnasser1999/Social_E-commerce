package com.nasser.ma99.social_e_commerce.Model;

import java.io.Serializable;
import java.util.Arrays;

public class campaignModel implements Serializable {
    private UserModel userModel;
    private String HeaderImgUrl;
    private String LogoUrl;
    private String BrandName;
    private String BrandDescription;
    private String[] Categories;
    private String BrandLink;
    private String CompanyName;
    private String CompanyType;
    private String CompanyDescription;
    private String[] BrandPlatforms = new String[4];
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
    private String[] ManagerDetails = new String[3];
    private String[] FinancialDetails = new String[5];
    private String[] BillingAddress = new String[4];


    public campaignModel(UserModel userModel, String headerImgUrl, String logoUrl, String brandName, String brandDescription, String[] categories, String brandLink, String companyName, String companyType, String companyDescription, String[] brandPlatforms, String[] preloadedContent, String aDo, String dont, String[] attachment, String influencerAge, int price, String influencerType, String influencerGender, String targetRegion, String influencerInterest, String paymentType, String publishDate, String endDate, String[] managerDetails, String[] financialDetails, String[] billingAddress) {
        this.userModel = userModel;
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
}

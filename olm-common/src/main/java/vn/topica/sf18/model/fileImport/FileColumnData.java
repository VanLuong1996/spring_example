package vn.topica.sf18.model.fileImport;

import vn.topica.sf18.constant.FileColumn;

public class FileColumnData {
    private String date_original;
    private String campaign;
    private Integer campaign_id;
    private String account;
    private String account_id;
    private String currency;
    private Integer impression;
    private Integer click;
    private Double amount;
    private Integer date_month;
    private Integer date_year;
    private String kenh;
    private String sp;
    private String cdt;
    private String pt;
    private String hd;
    private String phan_loai;

    public String getDate_original() {
        return date_original;
    }

    public void setDate_original(String date_original) {
        this.date_original = date_original;
    }

    public String getCampaign() {
        return campaign;
    }

    public void setCampaign(String campaign) {
        this.campaign = campaign;
    }

    public Integer getCampaign_id() {
        return campaign_id;
    }

    public void setCampaign_id(Integer campaign_id) {
        this.campaign_id = campaign_id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getAccount_id() {
        return account_id;
    }

    public void setAccount_id(String account_id) {
        this.account_id = account_id;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Integer getImpression() {
        return impression;
    }

    public void setImpression(Integer impression) {
        this.impression = impression;
    }

    public Integer getClick() {
        return click;
    }

    public void setClick(Integer click) {
        this.click = click;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Integer getDate_month() {
        return date_month;
    }

    public void setDate_month(Integer date_month) {
        this.date_month = date_month;
    }

    public Integer getDate_year() {
        return date_year;
    }

    public void setDate_year(Integer date_year) {
        this.date_year = date_year;
    }

    public String getKenh() {
        return kenh;
    }

    public void setKenh(String kenh) {
        this.kenh = kenh;
    }

    public String getSp() {
        return sp;
    }

    public void setSp(String sp) {
        this.sp = sp;
    }

    public String getCdt() {
        return cdt;
    }

    public void setCdt(String cdt) {
        this.cdt = cdt;
    }

    public String getPt() {
        return pt;
    }

    public void setPt(String pt) {
        this.pt = pt;
    }

    public String getHd() {
        return hd;
    }

    public void setHd(String hd) {
        this.hd = hd;
    }

    public String getPhan_loai() {
        return phan_loai;
    }

    public void setPhan_loai(String phan_loai) {
        this.phan_loai = phan_loai;
    }

    public void setDataFromColumnCode(FileColumn fileColumn, String value) {
        switch (fileColumn) {
            case Account:
                this.setAccount(value);
                break;
            case AccountID:
                this.setAccount_id(value);
                break;
            case Date:
                break;
            case Campaign:
                this.setCampaign(value);
                break;
            case CampaignID:
                this.setCampaign_id(Integer.valueOf(value));
                break;
            case HD:
                this.setHd(value);
                break;
            case PT:
                this.setPt(value);
                break;
            case CDT:
                this.setCdt(value);
                break;
            case SP:
                this.setSp(value);
                break;
            case Kenh:
                this.setKenh(value);
                break;
            case Currency:
                this.setCurrency(value);
                break;
            case Impression:
                this.setImpression(Integer.valueOf(value));
                break;
            case Click:
                this.setClick(Integer.valueOf(value));
                break;
            case Amount:
                value = value.replace(',', '.');
                //  System.out.println(value);
                this.setAmount(Double.valueOf(value));
                break;
            case DateMonth:
                this.setDate_month(Integer.valueOf(value));
                break;
            case DateYear:
                this.setDate_year(Integer.valueOf(value));
                break;
            case PhanLoai:
                this.setPhan_loai(value);
                break;
            case EffectiveDate:
                break;
            default:
                break;
        }

    }
}

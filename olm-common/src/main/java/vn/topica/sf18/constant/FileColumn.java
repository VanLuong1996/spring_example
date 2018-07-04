package vn.topica.sf18.constant;

public enum FileColumn {
    Date(3345),
    Campaign(3356),
    CampaignID(3360),
    Account(3371),
    AccountID(3382),
    Currency(3393),
    Impression(3404),
    Click(3415),
    Amount(3426),
    DateMonth(3430),
    DateYear(3441),
    Kenh(3452),
    SP(3463),
    CDT(3474),
    PT(3485),
    HD(3496),
    PhanLoai(3500),
    EffectiveDate(3511);

    private int code;

    FileColumn(int Code){
        code = Code;
    }

    public int getCode(){
        return this.code;
    }
}

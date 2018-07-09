package vn.topica.sf18.excel.constant;

public enum FileColumn {
  Date(3345, "Day"),
  Campaign(3356, "Campaign"),
  CampaignID(3360, "Campaign ID"),
  Account(3371),
  AccountID(3382),
  Currency(3393, "Currency"),
  Impression(3404, "Impressions"),
  Click(3415, "Clicks"),
  Amount(3426, "Cost"),
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

  private String name;

  FileColumn(int Code) {
    code = Code;
  }

  FileColumn(int Code, String Name) {
    code = Code;
    name = Name;
  }

  public int getCode() {
    return this.code;
  }

  public String getName() {
    return this.name;
  }
}

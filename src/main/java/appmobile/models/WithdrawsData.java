package appmobile.models;

public class WithdrawsData {
    private final String withdrawValue1;
    private final String beneficiaryName;
    private final String beneficiaryTypeId;
    private final String beneficiaryId;


    public WithdrawsData(String withdrawValue1, String beneficiaryName, String beneficiaryTypeId, String beneficiaryId) {
        this.withdrawValue1 = withdrawValue1;
        this.beneficiaryName = beneficiaryName;
        this.beneficiaryTypeId = beneficiaryTypeId;
        this.beneficiaryId = beneficiaryId;
    }

    public String getWithdrawValue1() {
        return withdrawValue1;
    }


    public String getBeneficiaryName() {
        return beneficiaryName;
    }

    public String getBeneficiaryTypeId() {
        return beneficiaryTypeId;
    }

    public String getBeneficiaryId() {
        return beneficiaryId;
    }
}

package appmobile.utils;

import appmobile.models.WithdrawsData;
import org.jetbrains.annotations.NotNull;

import java.util.Map;

public class WithdrawsDataTransformer {
    public WithdrawsData transformWithdrawsData(@NotNull Map<String, String> entry) {
        String withdrawValue1 = entry.get("withdrawValue1");
        String beneficiaryName = entry.get("beneficiaryName");
        String beneficiaryTypeId = entry.get("beneficiaryTypeId");
        String beneficiaryId = entry.get("beneficiaryId");


        return new WithdrawsData(withdrawValue1, beneficiaryName, beneficiaryTypeId, beneficiaryId);

    }


}
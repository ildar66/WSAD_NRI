package com.hps.july.platinum.sessionbean.arenda;

/**
 * Insert the type's description here.
 * Creation date: (17.01.2003 11:25:44)
 * @author: Alexander Shrago
 */
import com.hps.july.commonbean.KeyGeneratorAccessBean;
import com.hps.july.persistence.*;
//import org.apache.struts.util.*;
import com.hps.july.platinum.sessionbean.*;
public abstract class LogMessages implements LogMessageTypes {

    //  MoveAllPaymentsPlatinum2Nri  

    public static final LogMessageTemplate MES_PaymentNotCreated =
        new LogMessageTemplate(2001, ERROR, "Payment id={0} not created");

    public static final LogMessageTemplate MES_PaymentNotChanged =
        new LogMessageTemplate(2002, ERROR, "Payment id={0} not changed");

    public static final LogMessageTemplate MES_ChargeNotChanged =
        new LogMessageTemplate(2003, ERROR, "Charge id={0} not changed");

    public static final LogMessageTemplate MES_DocpositionNotDeleted =
        new LogMessageTemplate(
            2004,
            ERROR,
            "Error of DocPosition id={0,number} or its link deleting. Processed idpayplatinum={1}");

    public static final LogMessageTemplate MES_PaysLinkWithoutFlagMain =
        new LogMessageTemplate(
            2005,
            ERROR,
            "PaysLink without FlagMain found. idpayplatinum={0} iddocposition={1,number}");

    public static final LogMessageTemplate MES_FewCurrentAgreements =
        new LogMessageTemplate(
            2006,
            WARNING,
            "Few current agreements for mainLeaseDocumentId={0,number}");

    public static final LogMessageTemplate MES_FewPayRules =
        new LogMessageTemplate(
            2007,
            WARNING,
            "Few pay rules  for leaseDocumentId={0,number}");

    public static final LogMessageTemplate MES_PaymentSumZero =
        new LogMessageTemplate(2008, ERROR, "Payment id={0} has zero sum");

    public static final LogMessageTemplate MES_ChargeNotCreated =
        new LogMessageTemplate(2009, ERROR, "Payment id={0} not created");

    public static final LogMessageTemplate MES_PaysLinksWithFewFlagMain =
        new LogMessageTemplate(
            2010,
            ERROR,
            "PIE_PaysLink has few records idPayPlatinum={0} and iddocposition={1,number}");

    public static final LogMessageTemplate MES_CurrencyErrorInLinkDocPositions =
        new LogMessageTemplate(
            2011,
            ERROR,
            "DocPositions for idPayPlatinum={0} have different types of currency");

    public static final LogMessageTemplate MES_UnknownPayPlatinumProcessingError =
        new LogMessageTemplate(
            2012,
            ERROR,
            "Unknown error in PayPlatinum processing for idPayPlatinum={0}");

    public static final LogMessageTemplate MES_ConstantNotFoundError =
        new LogMessageTemplate(2013, ERROR, "Constant {0} not found");

    public static final LogMessageTemplate MES_ExistRecordsInDnopError =
        new LogMessageTemplate(
            2014,
            ERROR,
            "Exist records in DNOP for idPayPlatinum={0}");

    public static final LogMessageTemplate MES_CalculateSummError =
        new LogMessageTemplate(
            2015,
            ERROR,
            "Calculate sums error for idPayPlatinum={0}");

    //MoveBanksPlatinumToNri        

    public static final LogMessageTemplate MES_PlatinumBankNotProcessed =
        new LogMessageTemplate(
            2021,
            ERROR,
            "Bank of platinum with id={0} and owner={1,number} is not processed",
            STATUSTYPES.PREPAREERR);

    public static final LogMessageTemplate MES_PlatinumBanksProccessedError =
        new LogMessageTemplate(
            2022,
            ERROR,
            "Error of organizations looking. All  banks of Platinum  not processed",
            STATUSTYPES.PREPAREERR);

    public static final LogMessageTemplate MES_OwnerPlatinumBanksProcessedError =
        new LogMessageTemplate(
            2023,
            ERROR,
            "All or some of platinum banks with owner {0,number} are not processed",
            STATUSTYPES.PREPAREERR);

    public static final LogMessageTemplate MES_PlatinumBanksHasNoBik =
        new LogMessageTemplate(
            2024,
            ERROR,
            "Bank of platinum with id={0} and owner={1,number} is not processed besause has no bik");

    public static final LogMessageTemplate MES_PlatinumBanksWithDuplicatedBik =
        new LogMessageTemplate(
            2025,
            ERROR,
            "Bank of platinum with id={0} and owner={1,number} is not processed besause has bik is duplicated");

    public static final LogMessageTemplate MES_PlatinumBankProcessedOk =
        new LogMessageTemplate(
            2026,
            INF,
            "Bank of platinum with id={0} and owner={1,number} processed OK");

    /*
        public static final LogMessageTemplate MES_OwnerPlatinumBanksProcessedOk =
        new LogMessageTemplate(
            2027,
            INF,
            "All platinum banks with owner {0,number} processed OK");
    */
    //-----------
    //MoveDogovorNriToPlatinum

    public static final LogMessageTemplate MES_LeaseArendaArgmntsNotFound =
        new LogMessageTemplate(
            2041,
            ERROR,
            "record in LeaseArendaArgmnts not found",
            STATUSTYPES.ERROR);

    public static final LogMessageTemplate MES_SynchronizationSwitchedOff =
        new LogMessageTemplate(
            2042,
            INF,
            "The attribute of synchronization is switched off. The contract will not be transferred",
            STATUSTYPES.RESET);

    public static final LogMessageTemplate MES_NotNecessaryToTransfer =
        new LogMessageTemplate(
            2043,
            INF,
            "is not necessary to transfer",
            STATUSTYPES.RESET);

    public static final LogMessageTemplate MES_OperationNotDefined =
        new LogMessageTemplate(
            2044,
            ERROR,
            "Operation not defined",
            STATUSTYPES.PREPAREERR);

    public static final LogMessageTemplate MES_AccountNotDefined =
        new LogMessageTemplate(
            2045,
            WARNING,
            "not defined accountId",
            STATUSTYPES.PREPAREERR);

    public static final LogMessageTemplate MES_CreatePieDogovorsNriError =
        new LogMessageTemplate(
            2046,
            ERROR,
            "unknown create PieDogovorsNri error",
            STATUSTYPES.PREPAREERR);

    public static final LogMessageTemplate MES_MoveDogovorNriToPlatinumError =
        new LogMessageTemplate(
            2047,
            ERROR,
            "unknown error in func MoveDogovorNriToPlatinum ",
            STATUSTYPES.PREPAREERR);

    public final static LogMessageTemplate MES_MoveDogovorNriToPlatinumSuccess =
        new LogMessageTemplate(
            2048,
            INF,
            "func MoveDogovorNriToPlatinum done success",
            STATUSTYPES.PREPAREOK);

    public final static LogMessageTemplate MES_MoveDogovorNriToPlatinumDelete =
        new LogMessageTemplate(
            2049,
            INF,
            "func MoveDogovorNriToPlatinum: request for deleting was created",
            STATUSTYPES.PREPAREOK);

    //--------
    //MovePaymentNriToPlatinum
    public static final LogMessageTemplate MES_PaysNotTransfered =
        new LogMessageTemplate(
            2061,
            INF,
            "Not transfered pays to platinum because stateFrom={0}, stateTo={1}, typeAction={2}");

    public static final LogMessageTemplate MES_MovePaimentNriToPlatinumError =
        new LogMessageTemplate(
            2062,
            ERROR,
            "MovePaimentNriToPlatinum unknown error  stateFrom={0}, stateTo={1}, typeAction={2}");

    public static final LogMessageTemplate MES_MovePaimentNriToPlatinumSuccess =
        new LogMessageTemplate(
            2063,
            ERROR,
            "MovePaimentNriToPlatinum success stateFrom={0}, stateTo={1}, typeAction={2}",
            STATUSTYPES.PREPAREOK);

    public static final LogMessageTemplate MES_MovePaimentNriToPlatinum_RUR_Error =
        new LogMessageTemplate(
            2064,
            ERROR,
            "MovePaimentNriToPlatinum: RUR constant not found  stateFrom={0}, stateTo={1}, typeAction={2}",
            STATUSTYPES.PREPAREERR);

}

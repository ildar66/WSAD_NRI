package com.hps.july.inventory.formbean;

import com.hps.july.persistence.*;
import com.hps.july.web.util.*;

/**
 * Форма отчёта о необсчитанных документах
 */
public class MassdocForm extends ReportForm {
public MassdocForm() {
}
public int getState() {
	return com.hps.july.inventory.APPStates.MASSDOC;
}
}

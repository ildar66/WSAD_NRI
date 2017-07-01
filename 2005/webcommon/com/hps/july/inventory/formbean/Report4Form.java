package com.hps.july.inventory.formbean;

import com.hps.july.persistence.*;
import com.hps.july.web.util.*;

/**
 * Форма отчёта "Приход на объект"
 */
public class Report4Form extends ReportForm {
public Report4Form() {
}
public int getState() {
	return com.hps.july.inventory.APPStates.RPT4;
}
}

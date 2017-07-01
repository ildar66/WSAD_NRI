package com.hps.july.inventory.formbean;

import com.hps.july.persistence.*;
import com.hps.july.web.util.*;

/**
 * Форма отчёта "Оборудование, контракты и поставки"
 */
public class Report3Form extends ReportForm {
public Report3Form() {
}
public int getState() {
	return com.hps.july.inventory.APPStates.RPT3;
}
}

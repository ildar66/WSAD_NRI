package com.hps.july.inventory.formbean;

import com.hps.july.persistence.*;
import com.hps.july.web.util.*;

/**
 * Форма отчёта "История перемещений"
 */
public class Report91Form extends ReportForm {
public Report91Form() {
}
public int getState() {
	return com.hps.july.inventory.APPStates.RPT91;
}
}

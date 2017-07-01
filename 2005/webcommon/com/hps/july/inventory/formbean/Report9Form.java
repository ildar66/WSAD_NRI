package com.hps.july.inventory.formbean;

import com.hps.july.persistence.*;
import com.hps.july.web.util.*;

/**
 * Форма отчёта "История перемещений"
 */
public class Report9Form extends ReportForm {
public Report9Form() {
}
public int getState() {
	return com.hps.july.inventory.APPStates.RPT9;
}
}

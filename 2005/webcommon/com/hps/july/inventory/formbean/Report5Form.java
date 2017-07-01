package com.hps.july.inventory.formbean;

import com.hps.july.persistence.*;
import com.hps.july.web.util.*;

/**
 * Форма отчёта "Приход оборудования на объект"
 */
public class Report5Form extends ReportForm {
public Report5Form() {
}
public int getState() {
	return com.hps.july.inventory.APPStates.RPT5;
}
}

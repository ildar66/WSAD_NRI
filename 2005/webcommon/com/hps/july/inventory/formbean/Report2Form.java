package com.hps.july.inventory.formbean;

import com.hps.july.persistence.*;
import com.hps.july.web.util.*;

/**
 * Форма отчёта "Местоположение оборудования"
 */
public class Report2Form extends ReportForm {
public Report2Form() {
}
public int getState() {
	return com.hps.july.inventory.APPStates.RPT2;
}
}

package com.hps.july.inventory.formbean;

import com.hps.july.persistence.*;
import com.hps.july.web.util.*;

/**
 * Форма отчёта "Текущее местоположение"
 */
public class Report8Form extends ReportForm {
public Report8Form() {
}
public int getState() {
	return com.hps.july.inventory.APPStates.RPT8;
}
}

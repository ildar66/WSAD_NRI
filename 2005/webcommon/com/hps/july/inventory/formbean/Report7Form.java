package com.hps.july.inventory.formbean;

import com.hps.july.persistence.*;
import com.hps.july.web.util.*;

/**
 * Форма отчёта "Расход оборудования с объекта"
 */
public class Report7Form extends ReportForm {
public Report7Form() {
}
public int getState() {
	return com.hps.july.inventory.APPStates.RPT7;
}
}

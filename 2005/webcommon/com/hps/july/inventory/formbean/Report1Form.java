package com.hps.july.inventory.formbean;

import com.hps.july.persistence.*;
import com.hps.july.web.util.*;

/**
 * Форма отчёта "Наличие оборудования"
 */
public class Report1Form
	extends ReportForm
{
public Report1Form() {
}
public int getState() {
	return com.hps.july.inventory.APPStates.RPT1;
}
}

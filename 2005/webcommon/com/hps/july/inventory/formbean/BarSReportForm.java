package com.hps.july.inventory.formbean;

import com.hps.july.persistence.*;
import com.hps.july.web.util.*;

/**
 * Форма печати этикетки с выбранным штрих кодом
 */
public class BarSReportForm
	extends ReportForm
{
public BarSReportForm() {
}
public int getState() {
	return com.hps.july.inventory.APPStates.SERPRINT;
}
}

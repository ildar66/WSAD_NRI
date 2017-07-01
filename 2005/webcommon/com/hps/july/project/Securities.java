package com.hps.july.project;

/**
 * Интерфейс с константами для проверки прав доступа.
 * Creation date: (24.12.2002 14:58:52)
 * @author: Alexander Shrago
 */
public interface Securities {
    public static final String[] SECURITY_ADMIN = { "planAdmin", "administrator" };
    public static final String[] SECURITY_ALL =
        { "planResponsible", "planAdmin", "administrator", "planLook" };
    public static final String[] SECURITY_RESPONSIBLE =
        { "planResponsible", "administrator" };
}

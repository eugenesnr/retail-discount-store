package com.retail.store.api.enums;

/*
 * @author Tlotlo Lebotse
 * @description Customer type enumeration class
 * @version 1.0
 * 
 */
public enum UserEnums {
	
	EMPLOYEE(0.3),
	AFFILIATE(0.1),
	CUSTOMER(0.05);
	
	private final double enumValue;

    /**
     * The constructor with enumeration literal value allowing
     * super classes to access it.
     */
    private UserEnums(double enumValue)
    {
        this.enumValue = enumValue;
    }
    
    /**
     * Returns an enumeration Double
     * Required by JAXB2 enumeration implementation
     *
     * @return double with corresponding value
     */
    public Double getValue()
    {
        return this.enumValue;
    }


}

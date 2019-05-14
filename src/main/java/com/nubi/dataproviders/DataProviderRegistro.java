package com.nubi.dataproviders;

import org.testng.annotations.DataProvider;

public class DataProviderRegistro {

    @DataProvider(name = "dataproviderRegistroEmailValido")
    public static Object[][] dataProviderRegistroEmailValido()
    {
        return new Object[][] { { "" }};
    }//autouinubi@gmail.com

    @DataProvider(name = "dataproviderRegistroEmailInvalido")
    public static Object[][] dataProviderRegistroEmailInvalido()
    {
        return new Object[][] {
                { "testtest.com", "noArroba" },//sin arroba
                { "test@test", "noCom" },//sin .com
                { "test@testcom", "noPunto" },//sin puntos
                {"", "emailVacio"},// email vacio
                {"test#*@test.com", "carEspeciales"}// Validar con caracteres especiales excepto(@,.,-,_)
                              };
    }

    @DataProvider(name = "dataproviderRegistroDatosPersonales")
    public static Object[][] dataProviderRegistroDatosPersonales()
    {
        return new Object[][] {
                /*{ "", "apellido", "99999999", "H", "validarCampoNombre" },//validar campo nombre
                { "nombre", "", "99999999", "H", "validarCampoApellido" },//validar campo apellido
                { "nombre", "apellido", "", "H", "validarCampoDNI" },//validar campo DNI
                { "nombre", "apellido", "99999999", "", "validarOptionButton" },*///validar option button de genero
                { "Homero", "Simpsons", "25875465", "H", "datosPeronalesValidos" }//happy path
        };
    }

    @DataProvider(name = "dataproviderRetomaDeRegistro")
    public static Object[][] dataProviderRetomaDeRegistro()
    {
        return new Object[][] {
                { "nwtest03@yopmail.com"}
        };
    }

    @DataProvider(name = "dataproviderUsuarioPasswordRegistro")
    public static Object[][] dataproviderUsuarioPasswordRegistro()
    {
        return new Object[][] {
                { "user", "Test-Nubi1"}//happy path
        };
    }

    @DataProvider(name = "dataproviderValidationPhoneRegistro")
    public static Object[][] dataproviderValidationPhoneRegistro()
    {
        return new Object[][] {
                { "11", "999", "1010"}//happy path
        };
    }
}

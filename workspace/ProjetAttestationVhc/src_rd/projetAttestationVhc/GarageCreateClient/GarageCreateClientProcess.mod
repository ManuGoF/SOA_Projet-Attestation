[Ivy]
[>Created: Thu Apr 02 14:22:36 CEST 2015]
14C74C7BF34FFFC5 3.17 #module
>Proto >Proto Collection #zClass
Gs0 GarageCreateClientProcess Big #zClass
Gs0 RD #cInfo
Gs0 #process
Gs0 @TextInP .ui2RdDataAction .ui2RdDataAction #zField
Gs0 @TextInP .rdData2UIAction .rdData2UIAction #zField
Gs0 @TextInP .resExport .resExport #zField
Gs0 @TextInP .type .type #zField
Gs0 @TextInP .processKind .processKind #zField
Gs0 @AnnotationInP-0n ai ai #zField
Gs0 @MessageFlowInP-0n messageIn messageIn #zField
Gs0 @MessageFlowOutP-0n messageOut messageOut #zField
Gs0 @TextInP .xml .xml #zField
Gs0 @TextInP .responsibility .responsibility #zField
Gs0 @RichDialogInitStart f0 '' #zField
Gs0 @RichDialogProcessEnd f1 '' #zField
Gs0 @RichDialogProcessStart f3 '' #zField
Gs0 @WSElement f5 '' #zField
Gs0 @PushWFArc f6 '' #zField
Gs0 @RichDialogProcessStep f10 '' #zField
Gs0 @PushWFArc f11 '' #zField
Gs0 @RichDialogUiSync f12 '' #zField
Gs0 @PushWFArc f13 '' #zField
Gs0 @RichDialogProcessEnd f14 '' #zField
Gs0 @PushWFArc f15 '' #zField
Gs0 @WSElement f7 '' #zField
Gs0 @PushWFArc f16 '' #zField
Gs0 @WSElement f17 '' #zField
Gs0 @PushWFArc f18 '' #zField
Gs0 @WSElement f19 '' #zField
Gs0 @PushWFArc f20 '' #zField
Gs0 @WSElement f21 '' #zField
Gs0 @PushWFArc f22 '' #zField
Gs0 @RichDialogProcessStep f8 '' #zField
Gs0 @PushWFArc f9 '' #zField
Gs0 @PushWFArc f2 '' #zField
Gs0 @RichDialogProcessStart f23 '' #zField
Gs0 @RichDialogProcessStep f24 '' #zField
Gs0 @PushWFArc f25 '' #zField
Gs0 @RichDialogEnd f4 '' #zField
Gs0 @RichDialogProcessStep f27 '' #zField
Gs0 @PushWFArc f28 '' #zField
Gs0 @PushWFArc f26 '' #zField
>Proto Gs0 Gs0 GarageCreateClientProcess #zField
Gs0 f0 guid 14C74C7BF91D5378 #txt
Gs0 f0 type projetAttestationVhc.GarageCreateClient.GarageCreateClientData #txt
Gs0 f0 method start() #txt
Gs0 f0 disableUIEvents true #txt
Gs0 f0 inParameterDecl 'ch.ivyteam.ivy.richdialog.exec.RdMethodCallEvent methodEvent = event as ch.ivyteam.ivy.richdialog.exec.RdMethodCallEvent;
<> param = methodEvent.getInputArguments();
' #txt
Gs0 f0 outParameterDecl '<ch.comem.ws.CarTransport CarTransport,ch.comem.ws.CertificateTransport CertificateTransport> result;
' #txt
Gs0 f0 outParameterMapAction 'result.CarTransport=in.CarTransport;
result.CertificateTransport=in.CertificateTransport;
' #txt
Gs0 f0 embeddedRdInitializations '* ' #txt
Gs0 f0 @C|.xml '<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<elementInfo>
    <language>
        <name>start()</name>
        <nameStyle>7,5,7
</nameStyle>
    </language>
</elementInfo>
' #txt
Gs0 f0 83 51 26 26 -16 15 #rect
Gs0 f0 @|RichDialogInitStartIcon #fIcon
Gs0 f1 type projetAttestationVhc.GarageCreateClient.GarageCreateClientData #txt
Gs0 f1 1443 51 26 26 0 12 #rect
Gs0 f1 @|RichDialogProcessEndIcon #fIcon
Gs0 f3 guid 14C74E575A2DEE2F #txt
Gs0 f3 type projetAttestationVhc.GarageCreateClient.GarageCreateClientData #txt
Gs0 f3 actionDecl 'projetAttestationVhc.GarageCreateClient.GarageCreateClientData out;
' #txt
Gs0 f3 actionTable 'out=in;
out.ClientTransport.birthday=panel.Birthday.text;
out.ClientTransport.email=panel.Email.text;
out.ClientTransport.firstname=panel.FirstnameClient.text;
out.ClientTransport.lastname=panel.LastnameClient.text;
out.ClientTransport.licence_date=panel.Licence_date.text;
out.ClientTransport.licence_type=panel.Licence_type.text;
' #txt
Gs0 f3 @C|.xml '<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<elementInfo>
    <language>
        <name>CreateClientButton</name>
        <nameStyle>18,5,7
</nameStyle>
    </language>
</elementInfo>
' #txt
Gs0 f3 83 179 26 26 -52 15 #rect
Gs0 f3 @|RichDialogProcessStartIcon #fIcon
Gs0 f5 type projetAttestationVhc.GarageCreateClient.GarageCreateClientData #txt
Gs0 f5 actionDecl 'projetAttestationVhc.GarageCreateClient.GarageCreateClientData out;
' #txt
Gs0 f5 actionTable 'out=in;
' #txt
Gs0 f5 cache '{/cache false /invalidation false /scope 0 /groupname ""/lifetime_group "0"/invalidation_time_group ""/identifier ""/lifetime_entry "0"/invalidation_time_entry ""}' #txt
Gs0 f5 timeout 0 #txt
Gs0 f5 beanConfig '"KEY_PASSWORD=
KEY_AXIS_PORTNAME=insurranceWebServicePort
KEY_WEBSERVICECONFIG_ID=14C74B61A00491FE
KEY_DOMAIN=
KEY_USERNAME=
KEY_OPERATION=createClient
KEY_AUTHENTICATION_KIND=0
KEY_HOST=
KEY_USE_AUTHENTICATION=false
KEY_AXIS_CSL_PARAMETER_DATA=""arg0.createClient.client__@@__ch.comem.ws.ClientTransport__@@__in.ClientTransport"""' #txt
Gs0 f5 returningObjectList '[wsResponse]' #txt
Gs0 f5 @C|.xml '<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<elementInfo>
    <language>
        <name>createClient</name>
        <nameStyle>12
</nameStyle>
    </language>
</elementInfo>
' #txt
Gs0 f5 232 170 112 44 -33 -8 #rect
Gs0 f5 @|WebServiceIcon #fIcon
Gs0 f6 expr out #txt
Gs0 f6 109 192 232 192 #arcP
Gs0 f10 actionDecl 'projetAttestationVhc.GarageCreateClient.GarageCreateClientData out;
' #txt
Gs0 f10 actionTable 'out=in;
' #txt
Gs0 f10 actionCode 'import ch.comem.ws.ClientTransport;
ClientTransport c = new ClientTransport();
c.setEmail("1234");
in.ListClients.add(c);' #txt
Gs0 f10 type projetAttestationVhc.GarageCreateClient.GarageCreateClientData #txt
Gs0 f10 392 170 112 44 0 -8 #rect
Gs0 f10 @|RichDialogProcessStepIcon #fIcon
Gs0 f11 expr out #txt
Gs0 f11 344 192 392 192 #arcP
Gs0 f12 type projetAttestationVhc.GarageCreateClient.GarageCreateClientData #txt
Gs0 f12 guid 14C7545FD38EBEEC #txt
Gs0 f12 561 177 30 30 0 15 #rect
Gs0 f12 @|RichDialogUiSyncIcon #fIcon
Gs0 f13 expr out #txt
Gs0 f13 504 192 561 192 #arcP
Gs0 f14 type projetAttestationVhc.GarageCreateClient.GarageCreateClientData #txt
Gs0 f14 659 179 26 26 0 12 #rect
Gs0 f14 @|RichDialogProcessEndIcon #fIcon
Gs0 f15 expr out #txt
Gs0 f15 591 192 659 192 #arcP
Gs0 f7 type projetAttestationVhc.GarageCreateClient.GarageCreateClientData #txt
Gs0 f7 actionDecl 'projetAttestationVhc.GarageCreateClient.GarageCreateClientData out;
' #txt
Gs0 f7 actionTable 'out=in;
' #txt
Gs0 f7 cache '{/cache false /invalidation false /scope 0 /groupname ""/lifetime_group "0"/invalidation_time_group ""/identifier ""/lifetime_entry "0"/invalidation_time_entry ""}' #txt
Gs0 f7 timeout 0 #txt
Gs0 f7 beanConfig '"KEY_PASSWORD=
KEY_AXIS_PORTNAME=insurranceWebServicePort
KEY_WEBSERVICECONFIG_ID=14C74B61A00491FE
KEY_DOMAIN=
KEY_USERNAME=
KEY_OPERATION=readAllClients
KEY_AUTHENTICATION_KIND=0
KEY_HOST=
KEY_USE_AUTHENTICATION=false
KEY_AXIS_CSL_PARAMETER_DATA="' #txt
Gs0 f7 returningObjectList '[wsResponse]' #txt
Gs0 f7 @C|.xml '<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<elementInfo>
    <language>
        <name>getAllClients</name>
        <nameStyle>13
</nameStyle>
    </language>
</elementInfo>
' #txt
Gs0 f7 168 42 112 44 -34 -8 #rect
Gs0 f7 @|WebServiceIcon #fIcon
Gs0 f16 expr out #txt
Gs0 f16 109 64 168 64 #arcP
Gs0 f17 type projetAttestationVhc.GarageCreateClient.GarageCreateClientData #txt
Gs0 f17 actionDecl 'projetAttestationVhc.GarageCreateClient.GarageCreateClientData out;
' #txt
Gs0 f17 actionTable 'out=in;
out.ListCars=wsResponse.readAllCarsResponse._return;
' #txt
Gs0 f17 cache '{/cache false /invalidation false /scope 0 /groupname ""/lifetime_group "0"/invalidation_time_group ""/identifier ""/lifetime_entry "0"/invalidation_time_entry ""}' #txt
Gs0 f17 timeout 0 #txt
Gs0 f17 beanConfig '"KEY_PASSWORD=
KEY_AXIS_PORTNAME=insurranceWebServicePort
KEY_WEBSERVICECONFIG_ID=14C74B61A00491FE
KEY_DOMAIN=
KEY_USERNAME=
KEY_OPERATION=readAllCars
KEY_AUTHENTICATION_KIND=0
KEY_HOST=
KEY_USE_AUTHENTICATION=false
KEY_AXIS_CSL_PARAMETER_DATA="' #txt
Gs0 f17 returningObjectList '[wsResponse]' #txt
Gs0 f17 @C|.xml '<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<elementInfo>
    <language>
        <name>getAllCars</name>
        <nameStyle>10
</nameStyle>
    </language>
</elementInfo>
' #txt
Gs0 f17 328 42 112 44 -28 -8 #rect
Gs0 f17 @|WebServiceIcon #fIcon
Gs0 f18 expr out #txt
Gs0 f18 280 64 328 64 #arcP
Gs0 f19 type projetAttestationVhc.GarageCreateClient.GarageCreateClientData #txt
Gs0 f19 actionDecl 'projetAttestationVhc.GarageCreateClient.GarageCreateClientData out;
' #txt
Gs0 f19 actionTable 'out=in;
out.ListWorkers=wsResponse.readAllWorkersResponse._return;
' #txt
Gs0 f19 cache '{/cache false /invalidation false /scope 0 /groupname ""/lifetime_group "0"/invalidation_time_group ""/identifier ""/lifetime_entry "0"/invalidation_time_entry ""}' #txt
Gs0 f19 timeout 0 #txt
Gs0 f19 beanConfig '"KEY_PASSWORD=
KEY_AXIS_PORTNAME=insurranceWebServicePort
KEY_WEBSERVICECONFIG_ID=14C74B61A00491FE
KEY_DOMAIN=
KEY_USERNAME=
KEY_OPERATION=readAllWorkers
KEY_AUTHENTICATION_KIND=0
KEY_HOST=
KEY_USE_AUTHENTICATION=false
KEY_AXIS_CSL_PARAMETER_DATA="' #txt
Gs0 f19 returningObjectList '[wsResponse]' #txt
Gs0 f19 @C|.xml '<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<elementInfo>
    <language>
        <name>getAllWorkers</name>
        <nameStyle>13
</nameStyle>
    </language>
</elementInfo>
' #txt
Gs0 f19 488 42 112 44 -38 -8 #rect
Gs0 f19 @|WebServiceIcon #fIcon
Gs0 f20 expr out #txt
Gs0 f20 440 64 488 64 #arcP
Gs0 f21 type projetAttestationVhc.GarageCreateClient.GarageCreateClientData #txt
Gs0 f21 actionDecl 'projetAttestationVhc.GarageCreateClient.GarageCreateClientData out;
' #txt
Gs0 f21 actionTable 'out=in;
' #txt
Gs0 f21 cache '{/cache false /invalidation false /scope 0 /groupname ""/lifetime_group "0"/invalidation_time_group ""/identifier ""/lifetime_entry "0"/invalidation_time_entry ""}' #txt
Gs0 f21 timeout 0 #txt
Gs0 f21 beanConfig '"KEY_PASSWORD=
KEY_AXIS_PORTNAME=insurranceWebServicePort
KEY_WEBSERVICECONFIG_ID=14C74B61A00491FE
KEY_DOMAIN=
KEY_USERNAME=
KEY_OPERATION=readAllCertificates
KEY_AUTHENTICATION_KIND=0
KEY_HOST=
KEY_USE_AUTHENTICATION=false
KEY_AXIS_CSL_PARAMETER_DATA="' #txt
Gs0 f21 returningObjectList '[wsResponse]' #txt
Gs0 f21 @C|.xml '<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<elementInfo>
    <language>
        <name>getAllCertificates</name>
        <nameStyle>18
</nameStyle>
    </language>
</elementInfo>
' #txt
Gs0 f21 648 42 112 44 -46 -8 #rect
Gs0 f21 @|WebServiceIcon #fIcon
Gs0 f22 expr out #txt
Gs0 f22 600 64 648 64 #arcP
Gs0 f8 actionDecl 'projetAttestationVhc.GarageCreateClient.GarageCreateClientData out;
' #txt
Gs0 f8 actionTable 'out=in;
' #txt
Gs0 f8 panelTable 'panel.ComboCar.listData=in.ListCars;
panel.ComboboxCars.listData=in.ListCars;
' #txt
Gs0 f8 type projetAttestationVhc.GarageCreateClient.GarageCreateClientData #txt
Gs0 f8 1016 42 112 44 0 -8 #rect
Gs0 f8 @|RichDialogProcessStepIcon #fIcon
Gs0 f9 expr out #txt
Gs0 f9 760 64 1016 64 #arcP
Gs0 f2 expr out #txt
Gs0 f2 1128 64 1443 64 #arcP
Gs0 f23 guid 14C786BE7D266AD1 #txt
Gs0 f23 type projetAttestationVhc.GarageCreateClient.GarageCreateClientData #txt
Gs0 f23 actionDecl 'projetAttestationVhc.GarageCreateClient.GarageCreateClientData out;
' #txt
Gs0 f23 actionTable 'out=in;
' #txt
Gs0 f23 @C|.xml '<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<elementInfo>
    <language>
        <name>CreateCertificate</name>
        <nameStyle>17,5,7
</nameStyle>
    </language>
</elementInfo>
' #txt
Gs0 f23 83 307 26 26 -46 15 #rect
Gs0 f23 @|RichDialogProcessStartIcon #fIcon
Gs0 f24 actionDecl 'projetAttestationVhc.GarageCreateClient.GarageCreateClientData out;
' #txt
Gs0 f24 actionTable 'out=in;
out.CarTransport=in.ListCars.get(panel.ComboCar.selectedIndex);
out.CertificateNumber=panel.Number.text;
out.WorkerTransport=in.ListWorkers.get(panel.ComboWorker.selectedIndex);
' #txt
Gs0 f24 actionCode '
' #txt
Gs0 f24 type projetAttestationVhc.GarageCreateClient.GarageCreateClientData #txt
Gs0 f24 @C|.xml '<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<elementInfo>
    <language>
        <name>recupération des données du formulaire</name>
        <nameStyle>38
</nameStyle>
    </language>
</elementInfo>
' #txt
Gs0 f24 168 298 240 44 -110 -8 #rect
Gs0 f24 @|RichDialogProcessStepIcon #fIcon
Gs0 f25 expr out #txt
Gs0 f25 109 320 168 320 #arcP
Gs0 f4 type projetAttestationVhc.GarageCreateClient.GarageCreateClientData #txt
Gs0 f4 guid 14C78921C8777C9D #txt
Gs0 f4 739 307 26 26 0 12 #rect
Gs0 f4 @|RichDialogEndIcon #fIcon
Gs0 f27 actionDecl 'projetAttestationVhc.GarageCreateClient.GarageCreateClientData out;
' #txt
Gs0 f27 actionTable 'out=in;
' #txt
Gs0 f27 actionCode 'import ch.comem.ws.CertificateTransport;
CertificateTransport ct = new CertificateTransport();
ct.setCar_transport(in.CarTransport);
ct.setWorker_transport(in.WorkerTransport);
ct.setState("en attente");
ct.setCreation_date("2015-04-02");
ct.setId(in.CertificateNumber);
in.CertificateTransport = ct;' #txt
Gs0 f27 type projetAttestationVhc.GarageCreateClient.GarageCreateClientData #txt
Gs0 f27 @C|.xml '<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<elementInfo>
    <language>
        <name>creation du certificat transport</name>
        <nameStyle>32
</nameStyle>
    </language>
</elementInfo>
' #txt
Gs0 f27 472 298 176 44 -80 -8 #rect
Gs0 f27 @|RichDialogProcessStepIcon #fIcon
Gs0 f28 expr out #txt
Gs0 f28 408 320 472 320 #arcP
Gs0 f26 expr out #txt
Gs0 f26 648 320 739 320 #arcP
>Proto Gs0 .rdData2UIAction 'panel.ComboCar.listData=in.ListCars;
panel.ListWorkers.listData=in.ListWorkers;
panel.ComboWorker.listData=in.ListWorkers;
' #txt
>Proto Gs0 .type projetAttestationVhc.GarageCreateClient.GarageCreateClientData #txt
>Proto Gs0 .processKind RICH_DIALOG #txt
>Proto Gs0 -8 -8 16 16 16 26 #rect
>Proto Gs0 '' #fIcon
Gs0 f3 mainOut f6 tail #connect
Gs0 f6 head f5 mainIn #connect
Gs0 f5 mainOut f11 tail #connect
Gs0 f11 head f10 mainIn #connect
Gs0 f10 mainOut f13 tail #connect
Gs0 f13 head f12 mainIn #connect
Gs0 f12 mainOut f15 tail #connect
Gs0 f15 head f14 mainIn #connect
Gs0 f0 mainOut f16 tail #connect
Gs0 f16 head f7 mainIn #connect
Gs0 f7 mainOut f18 tail #connect
Gs0 f18 head f17 mainIn #connect
Gs0 f17 mainOut f20 tail #connect
Gs0 f20 head f19 mainIn #connect
Gs0 f19 mainOut f22 tail #connect
Gs0 f22 head f21 mainIn #connect
Gs0 f21 mainOut f9 tail #connect
Gs0 f9 head f8 mainIn #connect
Gs0 f8 mainOut f2 tail #connect
Gs0 f2 head f1 mainIn #connect
Gs0 f23 mainOut f25 tail #connect
Gs0 f25 head f24 mainIn #connect
Gs0 f24 mainOut f28 tail #connect
Gs0 f28 head f27 mainIn #connect
Gs0 f27 mainOut f26 tail #connect
Gs0 f26 head f4 mainIn #connect

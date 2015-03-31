[Ivy]
[>Created: Mon Mar 30 15:45:25 CEST 2015]
14C6AD5C140D6FD3 3.17 #module
>Proto >Proto Collection #zClass
Rs0 RIAComboboxProcess Big #zClass
Rs0 RD #cInfo
Rs0 #process
Rs0 @TextInP .ui2RdDataAction .ui2RdDataAction #zField
Rs0 @TextInP .rdData2UIAction .rdData2UIAction #zField
Rs0 @TextInP .resExport .resExport #zField
Rs0 @TextInP .type .type #zField
Rs0 @TextInP .processKind .processKind #zField
Rs0 @AnnotationInP-0n ai ai #zField
Rs0 @MessageFlowInP-0n messageIn messageIn #zField
Rs0 @MessageFlowOutP-0n messageOut messageOut #zField
Rs0 @TextInP .xml .xml #zField
Rs0 @TextInP .responsibility .responsibility #zField
Rs0 @RichDialogInitStart f0 '' #zField
Rs0 @RichDialogProcessEnd f1 '' #zField
Rs0 @WSElement f3 '' #zField
Rs0 @PushWFArc f4 '' #zField
Rs0 @PushWFArc f2 '' #zField
>Proto Rs0 Rs0 RIAComboboxProcess #zField
Rs0 f0 guid 14C6AD5C195E88F6 #txt
Rs0 f0 type projetTest.RIACombobox.RIAComboboxData #txt
Rs0 f0 method start(List<ch.comem.ws.BoatTransport>) #txt
Rs0 f0 disableUIEvents true #txt
Rs0 f0 inParameterDecl 'ch.ivyteam.ivy.richdialog.exec.RdMethodCallEvent methodEvent = event as ch.ivyteam.ivy.richdialog.exec.RdMethodCallEvent;
<List<ch.comem.ws.BoatTransport> listeBoatTransport> param = methodEvent.getInputArguments();
' #txt
Rs0 f0 inParameterMapAction 'out.listeBoatTransport=param.listeBoatTransport;
' #txt
Rs0 f0 outParameterDecl '<> result;
' #txt
Rs0 f0 @C|.xml '<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<elementInfo>
    <language>
        <name>start(List&lt;BoatTransport&gt;)</name>
    </language>
</elementInfo>
' #txt
Rs0 f0 83 51 26 26 -72 15 #rect
Rs0 f0 @|RichDialogInitStartIcon #fIcon
Rs0 f1 type projetTest.RIACombobox.RIAComboboxData #txt
Rs0 f1 339 51 26 26 0 12 #rect
Rs0 f1 @|RichDialogProcessEndIcon #fIcon
Rs0 f3 type projetTest.RIACombobox.RIAComboboxData #txt
Rs0 f3 actionDecl 'projetTest.RIACombobox.RIAComboboxData out;
' #txt
Rs0 f3 actionTable 'out=in;
out.listeBoatTransport=wsResponse.readBoatsHavingKitsResponse._return;
' #txt
Rs0 f3 cache '{/cache false /invalidation false /scope 0 /groupname ""/lifetime_group "0"/invalidation_time_group ""/identifier ""/lifetime_entry "0"/invalidation_time_entry ""}' #txt
Rs0 f3 timeout 0 #txt
Rs0 f3 beanConfig '"KEY_PASSWORD=
KEY_AXIS_PORTNAME=BoatWSPort
KEY_WEBSERVICECONFIG_ID=14C69EDF14641525
KEY_DOMAIN=
KEY_USERNAME=
KEY_OPERATION=readBoatsHavingKits
KEY_AUTHENTICATION_KIND=0
KEY_HOST=
KEY_USE_AUTHENTICATION=false
KEY_AXIS_CSL_PARAMETER_DATA="' #txt
Rs0 f3 returningObjectList '[wsResponse]' #txt
Rs0 f3 168 42 112 44 0 -8 #rect
Rs0 f3 @|WebServiceIcon #fIcon
Rs0 f4 expr out #txt
Rs0 f4 109 64 168 64 #arcP
Rs0 f2 expr out #txt
Rs0 f2 280 64 339 64 #arcP
>Proto Rs0 .rdData2UIAction 'panel.ComboBox.listData=in.listeBoatTransport;
' #txt
>Proto Rs0 .type projetTest.RIACombobox.RIAComboboxData #txt
>Proto Rs0 .processKind RICH_DIALOG #txt
>Proto Rs0 -8 -8 16 16 16 26 #rect
>Proto Rs0 '' #fIcon
Rs0 f0 mainOut f4 tail #connect
Rs0 f4 head f3 mainIn #connect
Rs0 f3 mainOut f2 tail #connect
Rs0 f2 head f1 mainIn #connect

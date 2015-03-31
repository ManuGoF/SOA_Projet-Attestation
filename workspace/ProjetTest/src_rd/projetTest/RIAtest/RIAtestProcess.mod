[Ivy]
[>Created: Mon Mar 30 14:02:35 CEST 2015]
14C6A61D128B47E5 3.17 #module
>Proto >Proto Collection #zClass
Rs0 RIAtestProcess Big #zClass
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
Rs0 @RichDialogProcessStep f3 '' #zField
Rs0 @PushWFArc f1 '' #zField
Rs0 @RichDialogProcessEnd f2 '' #zField
Rs0 @PushWFArc f4 '' #zField
>Proto Rs0 Rs0 RIAtestProcess #zField
Rs0 f0 guid 14C6A61D17384DF0 #txt
Rs0 f0 type projetTest.RIAtest.RIAtestData #txt
Rs0 f0 method start(String) #txt
Rs0 f0 disableUIEvents true #txt
Rs0 f0 inParameterDecl 'ch.ivyteam.ivy.richdialog.exec.RdMethodCallEvent methodEvent = event as ch.ivyteam.ivy.richdialog.exec.RdMethodCallEvent;
<java.lang.String prenomRIA> param = methodEvent.getInputArguments();
' #txt
Rs0 f0 inParameterMapAction 'out.prenomRIA=param.prenomRIA;
' #txt
Rs0 f0 outParameterDecl '<java.lang.Number prixRIA> result;
' #txt
Rs0 f0 outParameterMapAction 'result.prixRIA=in.prixRIA;
' #txt
Rs0 f0 @C|.xml '<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<elementInfo>
    <language>
        <name>start(String)</name>
    </language>
</elementInfo>
' #txt
Rs0 f0 83 51 26 26 -32 15 #rect
Rs0 f0 @|RichDialogInitStartIcon #fIcon
Rs0 f3 actionDecl 'projetTest.RIAtest.RIAtestData out;
' #txt
Rs0 f3 actionTable 'out=in;
' #txt
Rs0 f3 panelTable 'panel.Button.text=in.boatTransportRIA.name;
' #txt
Rs0 f3 type projetTest.RIAtest.RIAtestData #txt
Rs0 f3 192 42 112 44 0 -8 #rect
Rs0 f3 @|RichDialogProcessStepIcon #fIcon
Rs0 f1 expr out #txt
Rs0 f1 109 64 192 64 #arcP
Rs0 f2 type projetTest.RIAtest.RIAtestData #txt
Rs0 f2 387 51 26 26 0 12 #rect
Rs0 f2 @|RichDialogProcessEndIcon #fIcon
Rs0 f4 expr out #txt
Rs0 f4 304 64 387 64 #arcP
>Proto Rs0 .type projetTest.RIAtest.RIAtestData #txt
>Proto Rs0 .processKind RICH_DIALOG #txt
>Proto Rs0 -8 -8 16 16 16 26 #rect
>Proto Rs0 '' #fIcon
Rs0 f0 mainOut f1 tail #connect
Rs0 f1 head f3 mainIn #connect
Rs0 f3 mainOut f4 tail #connect
Rs0 f4 head f2 mainIn #connect

[Ivy]
[>Created: Mon Mar 30 15:06:36 CEST 2015]
14C6A9F742EB75A5 3.17 #module
>Proto >Proto Collection #zClass
Rs0 RIAboatProcess Big #zClass
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
Rs0 @PushWFArc f2 '' #zField
Rs0 @RichDialogProcessStart f3 '' #zField
Rs0 @RichDialogProcessStep f6 '' #zField
Rs0 @PushWFArc f7 '' #zField
Rs0 @RichDialogEnd f4 '' #zField
Rs0 @PushWFArc f5 '' #zField
>Proto Rs0 Rs0 RIAboatProcess #zField
Rs0 f0 guid 14C6A9F749363032 #txt
Rs0 f0 type projetTest.RIAboat.RIAboatData #txt
Rs0 f0 method start() #txt
Rs0 f0 disableUIEvents true #txt
Rs0 f0 inParameterDecl 'ch.ivyteam.ivy.richdialog.exec.RdMethodCallEvent methodEvent = event as ch.ivyteam.ivy.richdialog.exec.RdMethodCallEvent;
<> param = methodEvent.getInputArguments();
' #txt
Rs0 f0 outParameterDecl '<ch.comem.ws.BoatTransport boatTransportRIA> result;
' #txt
Rs0 f0 outParameterMapAction 'result.boatTransportRIA=in.boatTransportRIA;
' #txt
Rs0 f0 @C|.xml '<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<elementInfo>
    <language>
        <name>start()</name>
    </language>
</elementInfo>
' #txt
Rs0 f0 83 51 26 26 -16 15 #rect
Rs0 f0 @|RichDialogInitStartIcon #fIcon
Rs0 f1 type projetTest.RIAboat.RIAboatData #txt
Rs0 f1 211 51 26 26 0 12 #rect
Rs0 f1 @|RichDialogProcessEndIcon #fIcon
Rs0 f2 expr out #txt
Rs0 f2 109 64 211 64 #arcP
Rs0 f3 guid 14C6AA63AA06376D #txt
Rs0 f3 type projetTest.RIAboat.RIAboatData #txt
Rs0 f3 actionDecl 'projetTest.RIAboat.RIAboatData out;
' #txt
Rs0 f3 actionTable 'out=in;
' #txt
Rs0 f3 @C|.xml '<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<elementInfo>
    <language>
        <name>UD_Event_Start1</name>
    </language>
</elementInfo>
' #txt
Rs0 f3 195 243 26 26 -48 15 #rect
Rs0 f3 @|RichDialogProcessStartIcon #fIcon
Rs0 f6 actionDecl 'projetTest.RIAboat.RIAboatData out;
' #txt
Rs0 f6 actionTable 'out=in;
out.boatTransportRIA.name=panel.TextField1.text;
out.boatTransportRIA.number=panel.TextField.text;
' #txt
Rs0 f6 type projetTest.RIAboat.RIAboatData #txt
Rs0 f6 304 234 112 44 0 -8 #rect
Rs0 f6 @|RichDialogProcessStepIcon #fIcon
Rs0 f7 expr out #txt
Rs0 f7 221 256 304 256 #arcP
Rs0 f4 type projetTest.RIAboat.RIAboatData #txt
Rs0 f4 guid 14C6ACA63742AAA5 #txt
Rs0 f4 531 243 26 26 0 12 #rect
Rs0 f4 @|RichDialogEndIcon #fIcon
Rs0 f5 expr out #txt
Rs0 f5 416 256 531 256 #arcP
>Proto Rs0 .type projetTest.RIAboat.RIAboatData #txt
>Proto Rs0 .processKind RICH_DIALOG #txt
>Proto Rs0 -8 -8 16 16 16 26 #rect
>Proto Rs0 '' #fIcon
Rs0 f0 mainOut f2 tail #connect
Rs0 f2 head f1 mainIn #connect
Rs0 f3 mainOut f7 tail #connect
Rs0 f7 head f6 mainIn #connect
Rs0 f6 mainOut f5 tail #connect
Rs0 f5 head f4 mainIn #connect

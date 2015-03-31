[Ivy]
[>Created: Mon Mar 30 13:58:15 CEST 2015]
14C6A81EA58DA8CC 3.17 #module
>Proto >Proto Collection #zClass
Rs0 RIAtest2Process Big #zClass
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
Rs0 @RichDialogProcessStep f1 '' #zField
>Proto Rs0 Rs0 RIAtest2Process #zField
Rs0 f0 guid 14C6A81EAAE7EB1D #txt
Rs0 f0 type projetTest.RIAtest2.RIAtest2Data #txt
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
Rs0 f1 actionDecl 'projetTest.RIAtest2.RIAtest2Data out;
' #txt
Rs0 f1 actionTable 'out=in;
' #txt
Rs0 f1 type projetTest.RIAtest2.RIAtest2Data #txt
Rs0 f1 200 42 112 44 0 -8 #rect
Rs0 f1 @|RichDialogProcessStepIcon #fIcon
>Proto Rs0 .type projetTest.RIAtest2.RIAtest2Data #txt
>Proto Rs0 .processKind RICH_DIALOG #txt
>Proto Rs0 -8 -8 16 16 16 26 #rect
>Proto Rs0 '' #fIcon

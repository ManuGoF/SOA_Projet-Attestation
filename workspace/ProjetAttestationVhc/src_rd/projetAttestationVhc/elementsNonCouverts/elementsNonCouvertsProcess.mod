[Ivy]
[>Created: Thu Apr 02 15:51:38 CEST 2015]
14C79A428EA5C075 3.17 #module
>Proto >Proto Collection #zClass
es0 elementsNonCouvertsProcess Big #zClass
es0 RD #cInfo
es0 #process
es0 @TextInP .ui2RdDataAction .ui2RdDataAction #zField
es0 @TextInP .rdData2UIAction .rdData2UIAction #zField
es0 @TextInP .resExport .resExport #zField
es0 @TextInP .type .type #zField
es0 @TextInP .processKind .processKind #zField
es0 @AnnotationInP-0n ai ai #zField
es0 @MessageFlowInP-0n messageIn messageIn #zField
es0 @MessageFlowOutP-0n messageOut messageOut #zField
es0 @TextInP .xml .xml #zField
es0 @TextInP .responsibility .responsibility #zField
es0 @RichDialogInitStart f0 '' #zField
es0 @RichDialogProcessEnd f1 '' #zField
es0 @RichDialogProcessStep f3 '' #zField
es0 @PushWFArc f4 '' #zField
es0 @PushWFArc f2 '' #zField
es0 @RichDialogProcessStart f5 '' #zField
es0 @RichDialogProcessStart f6 '' #zField
es0 @RichDialogProcessStep f7 '' #zField
es0 @RichDialogProcessStep f8 '' #zField
es0 @RichDialogEnd f9 '' #zField
es0 @RichDialogEnd f10 '' #zField
es0 @PushWFArc f11 '' #zField
es0 @PushWFArc f12 '' #zField
es0 @PushWFArc f13 '' #zField
es0 @PushWFArc f14 '' #zField
>Proto es0 es0 elementsNonCouvertsProcess #zField
es0 f0 guid 14C79A4294029BCB #txt
es0 f0 type projetAttestationVhc.elementsNonCouverts.elementsNonCouvertsData #txt
es0 f0 method start(ch.comem.ws.CertificateTransport) #txt
es0 f0 disableUIEvents true #txt
es0 f0 inParameterDecl 'ch.ivyteam.ivy.richdialog.exec.RdMethodCallEvent methodEvent = event as ch.ivyteam.ivy.richdialog.exec.RdMethodCallEvent;
<ch.comem.ws.CertificateTransport CertificatInsurance> param = methodEvent.getInputArguments();
' #txt
es0 f0 inParameterMapAction 'out.data.certificateInsurrance=param.CertificatInsurance;
' #txt
es0 f0 outParameterDecl '<ch.comem.ws.CertificateTransport CertificatTransport,java.lang.Boolean isCovered> result;
' #txt
es0 f0 outParameterMapAction 'result.CertificatTransport=in.data.certificateInsurrance;
result.isCovered=in.data.isDropped;
' #txt
es0 f0 embeddedRdInitializations '* ' #txt
es0 f0 @C|.xml '<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<elementInfo>
    <language>
        <name>start(Data)</name>
        <nameStyle>11,5,7
</nameStyle>
    </language>
</elementInfo>
' #txt
es0 f0 83 51 26 26 -29 15 #rect
es0 f0 @|RichDialogInitStartIcon #fIcon
es0 f1 type projetAttestationVhc.elementsNonCouverts.elementsNonCouvertsData #txt
es0 f1 339 51 26 26 0 12 #rect
es0 f1 @|RichDialogProcessEndIcon #fIcon
es0 f3 actionDecl 'projetAttestationVhc.elementsNonCouverts.elementsNonCouvertsData out;
' #txt
es0 f3 actionTable 'out=in;
' #txt
es0 f3 type projetAttestationVhc.elementsNonCouverts.elementsNonCouvertsData #txt
es0 f3 168 42 112 44 0 -8 #rect
es0 f3 @|RichDialogProcessStepIcon #fIcon
es0 f4 expr out #txt
es0 f4 109 64 168 64 #arcP
es0 f2 expr out #txt
es0 f2 280 64 339 64 #arcP
es0 f5 guid 14C79D845E1A3720 #txt
es0 f5 type projetAttestationVhc.elementsNonCouverts.elementsNonCouvertsData #txt
es0 f5 actionDecl 'projetAttestationVhc.elementsNonCouverts.elementsNonCouvertsData out;
' #txt
es0 f5 actionTable 'out=in;
' #txt
es0 f5 @C|.xml '<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<elementInfo>
    <language>
        <name>couvert</name>
        <nameStyle>7,5,7
</nameStyle>
    </language>
</elementInfo>
' #txt
es0 f5 91 187 26 26 -19 15 #rect
es0 f5 @|RichDialogProcessStartIcon #fIcon
es0 f6 guid 14C79D84E4D2A7FD #txt
es0 f6 type projetAttestationVhc.elementsNonCouverts.elementsNonCouvertsData #txt
es0 f6 actionDecl 'projetAttestationVhc.elementsNonCouverts.elementsNonCouvertsData out;
' #txt
es0 f6 actionTable 'out=in;
' #txt
es0 f6 @C|.xml '<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<elementInfo>
    <language>
        <name>non couvert</name>
        <nameStyle>11,5,7
</nameStyle>
    </language>
</elementInfo>
' #txt
es0 f6 99 275 26 26 -31 15 #rect
es0 f6 @|RichDialogProcessStartIcon #fIcon
es0 f7 actionDecl 'projetAttestationVhc.elementsNonCouverts.elementsNonCouvertsData out;
' #txt
es0 f7 actionTable 'out=in;
out.data.certificateInsurrance=in.data.certificateInsurrance;
out.data.isDropped=false;
' #txt
es0 f7 type projetAttestationVhc.elementsNonCouverts.elementsNonCouvertsData #txt
es0 f7 184 170 112 44 0 -8 #rect
es0 f7 @|RichDialogProcessStepIcon #fIcon
es0 f8 actionDecl 'projetAttestationVhc.elementsNonCouverts.elementsNonCouvertsData out;
' #txt
es0 f8 actionTable 'out=in;
out.data.certificateInsurrance=in.data.certificateInsurrance;
out.data.isDropped=true;
' #txt
es0 f8 type projetAttestationVhc.elementsNonCouverts.elementsNonCouvertsData #txt
es0 f8 208 274 112 44 0 -8 #rect
es0 f8 @|RichDialogProcessStepIcon #fIcon
es0 f9 type projetAttestationVhc.elementsNonCouverts.elementsNonCouvertsData #txt
es0 f9 guid 14C79D92D5B97D91 #txt
es0 f9 435 179 26 26 0 12 #rect
es0 f9 @|RichDialogEndIcon #fIcon
es0 f10 type projetAttestationVhc.elementsNonCouverts.elementsNonCouvertsData #txt
es0 f10 guid 14C79D9344723798 #txt
es0 f10 467 275 26 26 0 12 #rect
es0 f10 @|RichDialogEndIcon #fIcon
es0 f11 expr out #txt
es0 f11 296 192 435 192 #arcP
es0 f12 expr out #txt
es0 f12 320 296 467 288 #arcP
es0 f13 expr out #txt
es0 f13 116 199 184 192 #arcP
es0 f14 expr out #txt
es0 f14 124 288 208 296 #arcP
>Proto es0 .type projetAttestationVhc.elementsNonCouverts.elementsNonCouvertsData #txt
>Proto es0 .processKind RICH_DIALOG #txt
>Proto es0 -8 -8 16 16 16 26 #rect
>Proto es0 '' #fIcon
es0 f0 mainOut f4 tail #connect
es0 f4 head f3 mainIn #connect
es0 f3 mainOut f2 tail #connect
es0 f2 head f1 mainIn #connect
es0 f7 mainOut f11 tail #connect
es0 f11 head f9 mainIn #connect
es0 f8 mainOut f12 tail #connect
es0 f12 head f10 mainIn #connect
es0 f5 mainOut f13 tail #connect
es0 f13 head f7 mainIn #connect
es0 f6 mainOut f14 tail #connect
es0 f14 head f8 mainIn #connect

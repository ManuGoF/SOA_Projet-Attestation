[Ivy]
[>Created: Thu Apr 02 14:21:14 CEST 2015]
14C797D8F5C61B27 3.17 #module
>Proto >Proto Collection #zClass
ds0 demandeRetraitProcess Big #zClass
ds0 RD #cInfo
ds0 #process
ds0 @TextInP .ui2RdDataAction .ui2RdDataAction #zField
ds0 @TextInP .rdData2UIAction .rdData2UIAction #zField
ds0 @TextInP .resExport .resExport #zField
ds0 @TextInP .type .type #zField
ds0 @TextInP .processKind .processKind #zField
ds0 @AnnotationInP-0n ai ai #zField
ds0 @MessageFlowInP-0n messageIn messageIn #zField
ds0 @MessageFlowOutP-0n messageOut messageOut #zField
ds0 @TextInP .xml .xml #zField
ds0 @TextInP .responsibility .responsibility #zField
ds0 @RichDialogInitStart f0 '' #zField
ds0 @RichDialogProcessEnd f1 '' #zField
ds0 @RichDialogProcessStep f3 '' #zField
ds0 @PushWFArc f4 '' #zField
ds0 @PushWFArc f2 '' #zField
ds0 @RichDialogProcessStart f5 '' #zField
ds0 @RichDialogProcessStart f6 '' #zField
ds0 @RichDialogProcessStep f7 '' #zField
ds0 @PushWFArc f8 '' #zField
ds0 @RichDialogEnd f9 '' #zField
ds0 @PushWFArc f10 '' #zField
ds0 @RichDialogProcessStep f11 '' #zField
ds0 @RichDialogEnd f12 '' #zField
ds0 @PushWFArc f13 '' #zField
ds0 @PushWFArc f14 '' #zField
>Proto ds0 ds0 demandeRetraitProcess #zField
ds0 f0 guid 14C797D8FAA8A8AD #txt
ds0 f0 type projetAttestationVhc.demandeRetrait.demandeRetraitData #txt
ds0 f0 method start(ch.comem.ws.CertificateTransport) #txt
ds0 f0 disableUIEvents true #txt
ds0 f0 inParameterDecl 'ch.ivyteam.ivy.richdialog.exec.RdMethodCallEvent methodEvent = event as ch.ivyteam.ivy.richdialog.exec.RdMethodCallEvent;
<ch.comem.ws.CertificateTransport Certificate> param = methodEvent.getInputArguments();
' #txt
ds0 f0 inParameterMapAction 'out.data.certificateInsurrance=param.Certificate;
' #txt
ds0 f0 outParameterDecl '<ch.comem.ws.CertificateTransport data,java.lang.Boolean isDropped> result;
' #txt
ds0 f0 outParameterMapAction 'result.data=in.data.certificateInsurrance;
result.isDropped=in.isDropped;
' #txt
ds0 f0 embeddedRdInitializations '* ' #txt
ds0 f0 @C|.xml '<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<elementInfo>
    <language>
        <name>start</name>
        <nameStyle>5,5,7
</nameStyle>
    </language>
</elementInfo>
' #txt
ds0 f0 83 51 26 26 -12 15 #rect
ds0 f0 @|RichDialogInitStartIcon #fIcon
ds0 f1 type projetAttestationVhc.demandeRetrait.demandeRetraitData #txt
ds0 f1 339 51 26 26 0 12 #rect
ds0 f1 @|RichDialogProcessEndIcon #fIcon
ds0 f3 actionDecl 'projetAttestationVhc.demandeRetrait.demandeRetraitData out;
' #txt
ds0 f3 actionTable 'out=in;
out.data.certificateInsurrance=in.data.certificateInsurrance;
out.isDropped=in.isDropped;
' #txt
ds0 f3 type projetAttestationVhc.demandeRetrait.demandeRetraitData #txt
ds0 f3 168 42 112 44 0 -8 #rect
ds0 f3 @|RichDialogProcessStepIcon #fIcon
ds0 f4 expr out #txt
ds0 f4 109 64 168 64 #arcP
ds0 f2 expr out #txt
ds0 f2 280 64 339 64 #arcP
ds0 f5 guid 14C799ADEAF74C6F #txt
ds0 f5 type projetAttestationVhc.demandeRetrait.demandeRetraitData #txt
ds0 f5 actionDecl 'projetAttestationVhc.demandeRetrait.demandeRetraitData out;
' #txt
ds0 f5 actionTable 'out=in;
' #txt
ds0 f5 @C|.xml '<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<elementInfo>
    <language>
        <name>Annuler</name>
        <nameStyle>7,5,7
</nameStyle>
    </language>
</elementInfo>
' #txt
ds0 f5 83 179 26 26 -21 15 #rect
ds0 f5 @|RichDialogProcessStartIcon #fIcon
ds0 f6 guid 14C799AE75E72FCF #txt
ds0 f6 type projetAttestationVhc.demandeRetrait.demandeRetraitData #txt
ds0 f6 actionDecl 'projetAttestationVhc.demandeRetrait.demandeRetraitData out;
' #txt
ds0 f6 actionTable 'out=in;
' #txt
ds0 f6 @C|.xml '<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<elementInfo>
    <language>
        <name>Transmettre</name>
        <nameStyle>11,5,7
</nameStyle>
    </language>
</elementInfo>
' #txt
ds0 f6 83 307 26 26 -33 15 #rect
ds0 f6 @|RichDialogProcessStartIcon #fIcon
ds0 f7 actionDecl 'projetAttestationVhc.demandeRetrait.demandeRetraitData out;
' #txt
ds0 f7 actionTable 'out=in;
out.data.certificateInsurrance=in.data.certificateInsurrance;
out.isDropped=true;
' #txt
ds0 f7 type projetAttestationVhc.demandeRetrait.demandeRetraitData #txt
ds0 f7 @C|.xml '<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<elementInfo>
    <language>
        <name>Set isDropped a false</name>
        <nameStyle>21
</nameStyle>
    </language>
</elementInfo>
' #txt
ds0 f7 224 170 128 44 -59 -8 #rect
ds0 f7 @|RichDialogProcessStepIcon #fIcon
ds0 f8 expr out #txt
ds0 f8 109 192 224 192 #arcP
ds0 f9 type projetAttestationVhc.demandeRetrait.demandeRetraitData #txt
ds0 f9 guid 14C799BB43C7C821 #txt
ds0 f9 467 179 26 26 0 12 #rect
ds0 f9 @|RichDialogEndIcon #fIcon
ds0 f10 expr out #txt
ds0 f10 352 192 467 192 #arcP
ds0 f11 actionDecl 'projetAttestationVhc.demandeRetrait.demandeRetraitData out;
' #txt
ds0 f11 actionTable 'out=in;
out.data.certificateInsurrance=in.data.certificateInsurrance;
out.isDropped=false;
' #txt
ds0 f11 type projetAttestationVhc.demandeRetrait.demandeRetraitData #txt
ds0 f11 @C|.xml '<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<elementInfo>
    <language>
        <name>Set isDropped a true</name>
        <nameStyle>20
</nameStyle>
    </language>
</elementInfo>
' #txt
ds0 f11 160 298 128 44 -56 -8 #rect
ds0 f11 @|RichDialogProcessStepIcon #fIcon
ds0 f12 type projetAttestationVhc.demandeRetrait.demandeRetraitData #txt
ds0 f12 guid 14C799BCD16FACA5 #txt
ds0 f12 419 307 26 26 0 12 #rect
ds0 f12 @|RichDialogEndIcon #fIcon
ds0 f13 expr out #txt
ds0 f13 109 320 160 320 #arcP
ds0 f14 expr out #txt
ds0 f14 288 320 419 320 #arcP
>Proto ds0 .type projetAttestationVhc.demandeRetrait.demandeRetraitData #txt
>Proto ds0 .processKind RICH_DIALOG #txt
>Proto ds0 -8 -8 16 16 16 26 #rect
>Proto ds0 '' #fIcon
ds0 f0 mainOut f4 tail #connect
ds0 f4 head f3 mainIn #connect
ds0 f3 mainOut f2 tail #connect
ds0 f2 head f1 mainIn #connect
ds0 f5 mainOut f8 tail #connect
ds0 f8 head f7 mainIn #connect
ds0 f7 mainOut f10 tail #connect
ds0 f10 head f9 mainIn #connect
ds0 f6 mainOut f13 tail #connect
ds0 f13 head f11 mainIn #connect
ds0 f11 mainOut f14 tail #connect
ds0 f14 head f12 mainIn #connect

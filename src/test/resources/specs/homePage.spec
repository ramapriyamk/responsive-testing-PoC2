@objects
       headerbar-*          css       li.has-sub-menu
       desktopHeader        css       .d-header
       mobileHeader         css       .m-header
       heroImage            css       .box1 .bx-viewport
       buyBtn               xpath     //li[@class='slide0']/div/div/a[1]
       learnMoreBox         css       .box2
       bigSaleBox           css       .box3
       bigfunBox            css       .box4
       QuotesSection        css       .bx-wrapper .bx-viewport #quotes
       unboxHTCImage*       css       section#why-htc a img
       item-listing         css       div.listing.four-items a.item
       Buttonforitem-*      css       a.item div.cta-button
       footerSection-*      css       .footer-wrapper div.footer-align-center
       
@groups
       section_boxes   learnMoreBox,bigSaleBox,bigfunBox

@rule stretches to %{parentName} by %{width}% of width and to %{height}% of height
   width ${width} % of ${parentName}/width
   height ${height} % of ${parentName}/height

@rule css properties of %{object}
   ${object}:
    css font-size is "13px"
    css color contains "96, 97, 98"   
    css font-family starts "LATO"   
       
=Header=
       @on desktop
        desktopHeader:
         image file pageDumps-desktop/objects/desktopHeader.png
       @on tablet
        desktopHeader:
         image file pageDumps-tablet/objects/desktopHeader.png
       @on Nexus
        mobileHeader:
         image file pageDumps-Nexus/objects/mobileHeader.png
       @on Iphone6plus
        mobileHeader:
         image file pageDumps-Iphone6plus/objects/mobileHeader.png
       
=Footer=
       @on desktop
        @for [1, 3] as i
         footerSection-${i}:
              image file pageDumps-desktop/objects/footerSection-${i}.png
       @on tablet
        @for [1, 3] as i
         footerSection-${i}:
              image file pageDumps-tablet/objects/footerSection-${i}.png
       @on Nexus
        @for [2, 3] as i
         footerSection-${i}:
              image file pageDumps-Nexus/objects/footerSection-${i}.png
       @on Iphone6plus
        @for [2, 3] as i
         footerSection-${i}:
              image file pageDumps-Iphone6plus/objects/footerSection-${i}.png

=section=
      @on Nexus,Iphone6plus
       | css properties of buyBtn
        @forEach [&section_boxes] as section, next as nextSection
         #, prev as previousSection 
          ${section}:
           aligned vertically all ${nextSection} 
           #aligned vertically all ${previousSection}
           width 100% of ${nextSection}/width
           #width 100% of ${previousSection}/width
           height 100% of ${nextSection}/height
           #height 100% of ${previousSection}/height
        @on desktop,tablet
         @forEach [&section_boxes] as section, next as nextSection
         #, prev as previousSection 
          ${section}:
           aligned horizontally all ${nextSection} 
           #aligned horizontally all ${previousSection}  
           | stretches to ${nextSection} by 100% of width and to 100% of height
           #| stretches to ${previousSection} by 100% of width and to 100% of height

=ViewPortSection=
       @on Iphone6plus
        buyBtn:
         width 38.5% of screen/width
         inside heroImage 343px top, 38px left, 197px right, 9px bottom
       @on Nexus,Iphone6plus
        @forEach [Buttonforitem-*] as button, next as nextButton
         	#, prev as prevButton
         ${button}:
          | stretches to ${nextButton} by 100% of width and to 100% of height
          #| stretches to ${prevButton} to 100% of width and to 100% of height
        @for [1 - 3] as i
         Buttonforitem-${i}:
           @if ${i === 1}
            aligned vertically all Buttonforitem-${i + 2} 
            aligned horizontally all Buttonforitem-${i + 1}
           @elseif ${i === 2}
            aligned horizontally all Buttonforitem-${i - 1}
           @else
            aligned vertically all Buttonforitem-${i - 2}
       @on desktop,tablet
        @forEach [Buttonforitem-*] as button, next as nextButton
        #, prev as prevButton
         ${button}:
          | stretches to ${nextButton} by 100% of width and to 100% of height
          #| stretches to ${prevButton} by 100% of width and to 100% of height
        @for [1 - 3] as i
         Buttonforitem-${i}: 
            @if ${i === 1}
             aligned horizontally all Buttonforitem-${i + 2} 
             aligned horizontally all Buttonforitem-${i + 1}
            @elseif ${i === 2}
             aligned horizontally all Buttonforitem-${i - 1}
             aligned horizontally all Buttonforitem-${i + 1}
            @else
             aligned horizontally all Buttonforitem-${i - 1}
             aligned horizontally all Buttonforitem-${i - 2}
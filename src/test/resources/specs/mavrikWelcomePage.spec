@objects
    header                  css   div.wrapper .logo-wrapper
	mavrik-header           css	  h1.mavrik
	mavrik-logo		        css   h1.mavrik .mavrik-logo
	progress-bar            css   div#step-indicator-container
	completed-progress-bar	css   rect[transform='scale(4.3, 1)']
	step-indicator-*        css   .steps-text li         
	footer			        css   div.flex-list.ng-scope
	SignInheader            css   div .signin h1
	Password-label          css   div .span12.signinpwd label
	Email-label             xpath //label[@for='email']  
	SignInBtn               css   button.proceed_btn.sign_in_btn
	Email                   id    email
	Password                id    password
	Problem-SignIn          css   a.active_link
	CreateNewAccountLink    css   p.message
	
@set
    ColorDesktopTab   	"rgba(112, 112, 112, 1)"
    	
= Header =
    @on *
     header:
      centered horizontally inside screen
     mavrik-header:
       css font-size is "16px"
     mavrik-logo:
       height 20px
       width 115px
     @on mobile
      mavrik-header:
       image file pageDumps-mobile/objects/mavrik-header.png
     @on desktop
      mavrik-header:
       image file pageDumps-desktop/objects/mavrik-header.png
     @on tablet
      mavrik-header:
       image file pageDumps-tablet/objects/mavrik-header.png

= Progress-Bar =
    @on desktop,tablet
      @for [ 1, 2, 4 ] as index
       step-indicator-${index}:
        css color is ${ColorDesktopTab}
        width 23 to 25% of progress-bar/width
        css font-size is "14.4px"
      @for [ 3 ] as index
       step-indicator-${index}:
        width 23 to 25% of progress-bar/width
        css transform is "matrix(1.3, 0, 0, 1.3, 0, 0)"
        css color is "rgba(0, 150, 208, 1)"
    @on mobile
      @for [ 3 ] as index
       step-indicator-${index}:
        aligned horizontally all step-indicator-${index - 1} 2px
        aligned horizontally all step-indicator-${index + 1} 2px
      @for [ 1, 2, 4 ] as index
       step-indicator-${index}:
        css font-size is "8px"
        css color is ${ColorDesktopTab}
      @for [ 3 ] as index
       step-indicator-${index}:
        css transform is "matrix(1.15, 0, 0, 1.15, 0, 0)"
        css color is "rgba(0, 150, 208, 1)"
 	
= footer =
    @on *
      footer:
       centered horizontally inside screen
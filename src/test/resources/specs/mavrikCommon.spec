@objects
	header			        css  div.wrapper .logo-wrapper
	mavrik-header	        css	 h1.mavrik
	mavrik-logo		        css  h1.mavrik .mavrik-logo
	progress-bar            css  div#step-indicator-container
	completed-progress-bar	css  rect[transform='scale(4.3, 1)']
	step-indicator-*        css  .steps-text li         
	footer			        css  div.flex-list.ng-scope
	
= Header =
    @on *
     header:
      centered horizontally inside screen
     mavrik-header:
       css font-size is "16px"
     mavrik-logo:
       height 20px
       width 115px

= Progress-Bar =
    @on *
      @forEach [step-indicator-*] as step, prev as prevStep
       ${step}:
        width 23 to 25% of progress-bar/width
    
    @on desktop,tablet
      @for [ 3 ] as index
       step-indicator-${index}:
        aligned horizontally all step-indicator-${index - 1} 5px
        aligned horizontally all step-indicator-${index + 1} 5px
    
    @on mobile
      @for [ 3 ] as index
       step-indicator-${index}:
        aligned horizontally all step-indicator-${index - 1} 1px
        aligned horizontally all step-indicator-${index + 1} 1px
        
    @on *
      @for [1,2] as index
       step-indicator-${index}:
        @if ${index === 1}
         aligned horizontally all step-indicator-${index + 1}
        @if ${index === 2}
         aligned horizontally all step-indicator-${index + 2}  
         
= footer =
    @on *
      footer:
       centered horizontally inside screen
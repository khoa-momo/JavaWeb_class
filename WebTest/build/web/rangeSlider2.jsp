<%-- 
    Document   : rangeSlider2
    Created on : 23-Mar-2022, 14:58:00
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>

            html{
              box-sizing: border-box;
            }

            *, *:before, *:after{
              box-sizing: inherit;
            }

            html,
            body{
              height: 100%;
              min-width: 500px;
            }

            body{
              background: #e8e8e8;
              -webkit-font-smoothing: antialiased;
            }

            sup{
              font-size: 80%;
              vertical-align: top;
              position: relative;
              top: 1px;
            }

            .wrapper{
              display: table;
              width: 100%;
              height: 100%;
            }

            .container{
              display: table-cell;
              vertical-align: middle;
              text-align: center;
            }



            .slider-wrapper{
              width: 500px;
              display: inline-block;
              position: relative;
              font-family: arial;
            }

            .ui-slider{
              background: #efefef;
              border: 1px solid #d2d2d2;
              height: 20px;
              position: relative;
              border-radius: 100px;
            }

            .ui-slider-range{
              background: #71c0ff;
              height: 20px;
              position: absolute;
              border-top: 1px solid #5d99c8;
              border-bottom: 1px solid #5d99c8;
              transform: translateY(-1px);

              &:after{
                content: '';
                width: 100%;
                height: 1px;
                background: #fff;
                position: absolute;
                top: 0;
                left: 0;
                opacity: 0.3;
              }
            }

            .ui-slider-handle{
              background: #555;
              position: absolute;
              width: 32px;
              height: 32px;
              top: 50%;
              display: block;
              transform: translate(-50%, -50%);
              border-radius: 100px;
              z-index: 10;
              background: linear-gradient(#555, #454545);
              cursor: move; /* fallback if grab cursor is unsupported */
              cursor: grab;
              cursor: -moz-grab;
              cursor: -webkit-grab;
              box-shadow: inset -2px -2px 6px 2px rgba(0,0,0, 0.1);
              transition: width 0.1s;

              &:focus{
                outline: none;
              }

              &:active{
                cursor: grabbing;
                cursor: -moz-grabbing;
                cursor: -webkit-grabbing;
              }
            }

            .ui-state-active{
              width: 22px;
            }



            .range-wrapper{
              position: absolute;
              top: -50px;
              left: 50%;
              transform: translateX(-50%);
            }

            .range{
              background: #fff;
              white-space: nowrap;
              border: 1px solid #d2d2d2;
              border-radius: 2px;
              font-size: 13px;
              letter-spacing: 0.02em;
              color: #555;
              width: 150px;
              z-index: 10;
              position: relative;

              &:after{
                content: '';
                position: absolute;
                top: 100%;
                left: 50%;
                transform: translateX(-50%);
                border-left: 67px solid transparent;
                border-right: 67px solid transparent;
                border-top: 6px solid #d2d2d2;
              }
            }

            .range-value{
              width: 74px;
              padding: 8px 0;
              text-align: center;
              display: inline-block;
              transition: background 0.1s;
            }

            .range-divider{
              width: 1px;
              display: inline-block;

              &:after{
                position: absolute;
                top: 0;
                left: 50%;
                width: 1px;
                height: 100%;
                background: #d2d2d2;
                content: '';
              }
            }

            .range-alert{
              width: 16px;
              height: 16px;
              position: absolute;
              top: 50%;
              right: 0;
              transform: translateY(-50%);
              background: #fff;
              border-top-right-radius: 2px;
              border-bottom-right-radius: 2px;
              border: 1px solid #d2d2d2;
              color: #0E0E0E;
              line-height: 15px;
              transition: right 0.2s;

              &.active{
                right: -15px;
              }
            }




            .marker{
              position: absolute;
              top: 100%;
              padding-top: 16px;
              font-size: 13px;
              color: #555;
              letter-spacing: 0.05em;
              transform: translateX(-50%);

              &:after{
                content: '';
                width: 1px;
                height: 8px;
                background: #d2d2d2;
                position: absolute;
                top: 0;
                left: 50%;
                transform: translateX(-50%);
              }
            }

            .marker-0{
              &:after{
                display: none;
              }
            }

            .marker-25{
              left: 25%;
            }

            .marker-50{
              left: 50%;
            }

            .marker-75{
              left: 75%;
            }

            .marker-100{
              right: 0;
              transform: translateX(50%);

              &:after{
                display: none;
              }
            }




            .gear-wrapper{
              position: absolute;
              top: -14px;
              left: 50%;
              transform: translateX(-50%);
              z-index: 5;
              backface-visibility: hidden;
              width: 150px;
              height: 20px;
              overflow: hidden;
            }

            .gear-large{
              width: 40px;
              height: 40px;
              background: #d2d2d2;
              border-radius: 100px;
              position: absolute;
              top: 18px;
              left: 18px;
              transform-origin: 50% 50%;
              transition: top 0.15s;

              &:after{
                position: absolute;
                content: '';
                width: 28px;
                height: 28px;
                top: 50%;
                left: 50%;
                transform: translate(-50%, -50%);
                background: #e8e8e8;
                border-radius: 100px;
              }

              &:nth-child(2){
                background: #d2d2d2;
                left: auto;
                right: 18px;

                & .gear-tooth{
                  background: #d2d2d2;
                }
              }

              &.active{
                top: 4px;
              }
            }

            .gear-tooth{
              width: 22%;
              height: 114%;
              position: absolute;
              top: 50%;
              left: 50%;
              transform: translate(-50%, -50%);
              transform-origin: 0 0;
              background: #d2d2d2;
              border-radius: 2px;

              &:nth-child(2){
                transform: rotate(90deg) translate(-50%, -50%);
              }

              &:nth-child(3){
                transform: rotate(45deg) translate(-50%, -50%);
              }

              &:nth-child(4){
                transform: rotate(-45deg) translate(-50%, -50%);
              }
            }

        </style>
    </head>
    <body>
        <section>
        <div class="wrapper">
            <div class="container">

              <div class="slider-wrapper">
                <div id="slider-range"></div>

                <div class="range-wrapper">
                  <div class="range"></div>
                  <div class="range-alert">+</div>

                  <div class="gear-wrapper">
                    <div class="gear-large gear-one">
                      <div class="gear-tooth"></div>
                      <div class="gear-tooth"></div>
                      <div class="gear-tooth"></div>
                      <div class="gear-tooth"></div>
                    </div>
                    <div class="gear-large gear-two">
                      <div class="gear-tooth"></div>
                      <div class="gear-tooth"></div>
                      <div class="gear-tooth"></div>
                      <div class="gear-tooth"></div>
                    </div>
                  </div>

                </div>

                <div class="marker marker-0"><sup>$</sup>10,000</div>
                <div class="marker marker-25"><sup>$</sup>35,000</div>
                <div class="marker marker-50"><sup>$</sup>60,000</div>
                <div class="marker marker-75"><sup>$</sup>85,000</div>
                <div class="marker marker-100"><sup>$</sup>110,000+</div>
              </div>

            </div>
          </div>
        </section>
        <script type="text/javascript">
            $(function() {

            // Initiate Slider
            $('#slider-range').slider({
              range: true,
              min: 10000,
              max: 110000,
              step: 100,
              values: [45000, 75000]
            });

            // Move the range wrapper into the generated divs
            $('.ui-slider-range').append($('.range-wrapper'));

            // Apply initial values to the range container
            $('.range').html('<span class="range-value"><sup>$</sup>' + $('#slider-range').slider("values", 0).toString().replace(/(\d)(?=(\d\d\d)+(?!\d))/g, "$1,") + '</span><span class="range-divider"></span><span class="range-value"><sup>$</sup>' + $("#slider-range").slider("values", 1).toString().replace(/(\d)(?=(\d\d\d)+(?!\d))/g, "$1,") + '</span>');

            // Show the gears on press of the handles
            $('.ui-slider-handle, .ui-slider-range').on('mousedown', function() {
              $('.gear-large').addClass('active');
            });

            // Hide the gears when the mouse is released
            // Done on document just incase the user hovers off of the handle
            $(document).on('mouseup', function() {
              if ($('.gear-large').hasClass('active')) {
                $('.gear-large').removeClass('active');
              }
            });

            // Rotate the gears
            var gearOneAngle = 0,
              gearTwoAngle = 0,
              rangeWidth = $('.ui-slider-range').css('width');

            $('.gear-one').css('transform', 'rotate(' + gearOneAngle + 'deg)');
            $('.gear-two').css('transform', 'rotate(' + gearTwoAngle + 'deg)');

            $('#slider-range').slider({
              slide: function(event, ui) {

                // Update the range container values upon sliding

                $('.range').html('<span class="range-value"><sup>$</sup>' + ui.values[0].toString().replace(/(\d)(?=(\d\d\d)+(?!\d))/g, "$1,") + '</span><span class="range-divider"></span><span class="range-value"><sup>$</sup>' + ui.values[1].toString().replace(/(\d)(?=(\d\d\d)+(?!\d))/g, "$1,") + '</span>');

                // Get old value
                var previousVal = parseInt($(this).data('value'));

                // Save new value
                $(this).data({
                  'value': parseInt(ui.value)
                });

                // Figure out which handle is being used
                if (ui.values[0] == ui.value) {

                  // Left handle
                  if (previousVal > parseInt(ui.value)) {
                    // value decreased
                    gearOneAngle -= 7;
                    $('.gear-one').css('transform', 'rotate(' + gearOneAngle + 'deg)');
                  } else {
                    // value increased
                    gearOneAngle += 7;
                    $('.gear-one').css('transform', 'rotate(' + gearOneAngle + 'deg)');
                  }

                } else {

                  // Right handle
                  if (previousVal > parseInt(ui.value)) {
                    // value decreased
                    gearOneAngle -= 7;
                    $('.gear-two').css('transform', 'rotate(' + gearOneAngle + 'deg)');
                  } else {
                    // value increased
                    gearOneAngle += 7;
                    $('.gear-two').css('transform', 'rotate(' + gearOneAngle + 'deg)');
                  }

                }

                if (ui.values[1] === 110000) {
                  if (!$('.range-alert').hasClass('active')) {
                    $('.range-alert').addClass('active');
                  }
                } else {
                  if ($('.range-alert').hasClass('active')) {
                    $('.range-alert').removeClass('active');
                  }
                }
              }
            });

            // Prevent the range container from moving the slider
            $('.range, .range-alert').on('mousedown', function(event) {
              event.stopPropagation();
            });

          });
        </script>
    </body>
    

</html>

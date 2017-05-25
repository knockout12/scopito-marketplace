jQuery.noConflict();
jQuery(document).ready(function(){


    jQuery(document).ready(function(){

        jQuery("#grid-btn").addClass("active");
        jQuery("#list-btn").removeClass("active");
        jQuery("#list-view").hide();
        jQuery("#grid-view").show();
        jQuery("#welcome-modal").modal("show");

    });



    //Makes the advanced search arrow rotate
    //Not using toggle method because sometimes rotation was mismatched with the view

    jQuery("#chevron").click(function(){
        if(jQuery("#advanced-search").hasClass("in")){
            jQuery(this).removeClass("rotate-minus-90");
            jQuery(this).addClass("rotate-90");
        }

        else{
            jQuery(this).removeClass("rotate-90");
            jQuery(this).addClass("rotate-minus-90");
        }
    });

    //Grid and list view button functionality

    jQuery("#grid-btn").click(function(){
        jQuery("#grid-btn").addClass("active");
        jQuery("#list-btn").removeClass("active");
        jQuery("#list-view").hide();
        jQuery("#grid-view").show();

    });

    jQuery("#list-btn").click(function(){
        jQuery("#list-btn").addClass("active");
        jQuery("#grid-btn").removeClass("active");
        jQuery("#grid-view").hide();
        jQuery("#list-view").show();
    });

});

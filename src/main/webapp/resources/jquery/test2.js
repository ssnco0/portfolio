function dialog() {

  var dialogBox = $('.pup'),
    dialogTrigger = $('.pup_trg'),
    dialogClose = $('.pup_clo'),
    dialogAction = $('.pup_bt');

  // Open the dialog
  dialogTrigger.on('click', function(e) {
    dialogBox.toggleClass('pup_act');
    e.stopPropagation()
  });

  // Close the dialog - click close button
  dialogClose.on('click', function() {
    dialogBox.removeClass('pup_act');
  });
}

// Run function when the document has loaded
$(function() {
  dialog();
});

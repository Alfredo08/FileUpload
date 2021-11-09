
function openModal( event ){
    let modal = document.querySelector( ".modalContainer" );
    let modalImage = document.querySelector( ".modalImage" );
    let modalImageId = document.querySelector( "#imageId" );
    modalImage.setAttribute( 'src', event.target.closest( 'div' ).querySelector( 'img' ).getAttribute( 'src' ));
    modalImageId.setAttribute( "value", event.target.id)
	modal.classList.remove( "hidden" );
}

function closeModal( event ){
    let modal = document.querySelector( ".modalContainer" );
    modal.classList.add( "hidden" );
}

let deleteButtons = document.querySelectorAll(".deleteImage");

for( let i = 0; i < deleteButtons.length; i ++ ){
    deleteButtons[i].addEventListener( "click", openModal );
}

let modalCancelButton = document.querySelector( ".modalCancel" );

modalCancelButton.addEventListener( 'click', closeModal );

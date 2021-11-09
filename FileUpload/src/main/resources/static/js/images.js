
function openModal( event ){
    let modal = document.querySelector( ".modalContainer" );
    let modalImage = document.querySelector( ".modalImage" );
    let modalImageId = document.querySelector( "#imageId" );
    let modalImageName = document.querySelector( "#imageName" );
    let imagePath = event.target.closest( 'div' ).querySelector( 'img' ).getAttribute( 'src' );
    let imageName = imagePath.split("/")[2];
    modalImage.setAttribute( 'src', imagePath );
    modalImageId.setAttribute( "value", event.target.id);
    modalImageName.setAttribute( "value", imageName );
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

/**
 * 
 */
function allowDrop(event) {
    event.preventDefault();
}

function drag(event) {
    event.dataTransfer.setData("text", event.target.id);
}

function drop(event) {
    event.preventDefault();
    const data = event.dataTransfer.getData("text");
    const draggedElement = document.getElementById(data);

    // Find the target list
    const targetList = event.target.closest('.list');

    // Append the dragged element to the target list
    targetList.appendChild(draggedElement);

    // Perform database update here using AJAX or fetch
    updateTaskListInDatabase(data, targetList.id);
}

function updateTaskListInDatabase(taskId, newListId) {
    // Implement AJAX or fetch to update the task list in the database
    // Example:
    // fetch(`/updateTaskList?taskId=${taskId}&newListId=${newListId}`, {
    //     method: 'PUT',
    // });
}

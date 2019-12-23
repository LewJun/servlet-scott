/**
 * 表单序列化
 * @param form
 */
function formser(form) {
    var arr = {};
    for (var i = 0; i < form.elements.length; i++) {
        var ele = form.elements[i];
        switch (ele.type) {
            case undefined:
            case 'button':
            case 'file':
            case 'reset':
            case 'submit':
                break;
            case 'checkbox':
            case 'radio':
                if (!ele.checked) {
                    break;
                }
            default:
                if (arr[ele.name]) {
                    arr[ele.name] = arr[ele.name] + ',' + ele.value;
                } else {
                    arr[ele.name] = ele.value;
                }
        }
    }
    return arr
}
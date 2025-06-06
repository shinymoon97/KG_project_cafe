document.addEventListener('DOMContentLoaded', () => {
    // 장바구니 페이지인 경우 장바구니 내용을 렌더링
    if (document.querySelector('.cart-items-container')) {
        renderCartPage();
    }
    // 모든 페이지에서 장바구니 아이콘 카운트 업데이트
    updateCartCountDisplayGlobal(); 
});

// 전역에서 접근 가능하도록 window 객체에 할당 (main.js에서 사용하기 위함)
window.addItemToCart = function(product) {
    let cart = JSON.parse(localStorage.getItem('newCoffeeCart')) || [];
    const existingItemIndex = cart.findIndex(item => item.id === product.id);

    if (existingItemIndex > -1) {
        cart[existingItemIndex].quantity += 1;
    } else {
        cart.push({ ...product, quantity: 1 });
    }

    localStorage.setItem('newCoffeeCart', JSON.stringify(cart));
    alert(`${product.name}이(가) 장바구니에 추가되었습니다.`);
    updateCartCountDisplayGlobal();
}

function updateCartCountDisplayGlobal() {
    const cart = JSON.parse(localStorage.getItem('newCoffeeCart')) || [];
    const cartCountElement = document.getElementById('cart-count');
    if (cartCountElement) {
        let totalItems = 0;
        cart.forEach(item => totalItems += item.quantity);
        cartCountElement.textContent = totalItems;
    }
}

function renderCartPage() {
    const cartItemsContainer = document.querySelector('.cart-items-container');
    const cartTotalElement = document.getElementById('cart-total-price');
    if (!cartItemsContainer || !cartTotalElement) return;

    const cart = JSON.parse(localStorage.getItem('newCoffeeCart')) || [];
    cartItemsContainer.innerHTML = ''; // 기존 내용 초기화

    if (cart.length === 0) {
        cartItemsContainer.innerHTML = '<p>장바구니가 비어있습니다.</p>';
        cartTotalElement.textContent = '0원';
        return;
    }

    let totalPrice = 0;
    cart.forEach((item, index) => {
        const itemElement = document.createElement('div');
        itemElement.classList.add('cart-item');
        itemElement.innerHTML = `
            <img src="/images/coffee_placeholder.jpg" alt="${item.name}" class="cart-item-image"> <!-- 실제 이미지 경로 필요 -->
            <div class="cart-item-details">
                <h4>${item.name}</h4>
                <p>가격: ${item.price.toLocaleString()}원</p>
                <div class="quantity-controls">
                    <button class="quantity-btn minus-btn" data-index="${index}">-</button>
                    <span>${item.quantity}</span>
                    <button class="quantity-btn plus-btn" data-index="${index}">+</button>
                </div>
            </div>
            <p class="cart-item-subtotal">소계: ${(item.price * item.quantity).toLocaleString()}원</p>
            <button class="remove-item-btn" data-index="${index}">삭제</button>
        `;
        cartItemsContainer.appendChild(itemElement);
        totalPrice += item.price * item.quantity;
    });

    cartTotalElement.textContent = `${totalPrice.toLocaleString()}원`;
    addCartEventListeners();
}

function addCartEventListeners() {
    document.querySelectorAll('.remove-item-btn').forEach(button => {
        button.addEventListener('click', (e) => {
            const index = parseInt(e.target.dataset.index);
            removeItemFromCart(index);
        });
    });

    document.querySelectorAll('.plus-btn').forEach(button => {
        button.addEventListener('click', (e) => {
            const index = parseInt(e.target.dataset.index);
            updateItemQuantity(index, 1);
        });
    });

    document.querySelectorAll('.minus-btn').forEach(button => {
        button.addEventListener('click', (e) => {
            const index = parseInt(e.target.dataset.index);
            updateItemQuantity(index, -1);
        });
    });
}

function removeItemFromCart(index) {
    let cart = JSON.parse(localStorage.getItem('newCoffeeCart')) || [];
    cart.splice(index, 1);
    localStorage.setItem('newCoffeeCart', JSON.stringify(cart));
    renderCartPage(); // 페이지 다시 렌더링
    updateCartCountDisplayGlobal(); // 헤더 카운트 업데이트
}

function updateItemQuantity(index, change) {
    let cart = JSON.parse(localStorage.getItem('newCoffeeCart')) || [];
    if (cart[index]) {
        cart[index].quantity += change;
        if (cart[index].quantity <= 0) {
            cart.splice(index, 1); // 수량이 0 이하이면 삭제
        }
    }
    localStorage.setItem('newCoffeeCart', JSON.stringify(cart));
    renderCartPage(); // 페이지 다시 렌더링
    updateCartCountDisplayGlobal(); // 헤더 카운트 업데이트
}

// cart.html 페이지 로드 시 장바구니 렌더링 (DOMContentLoaded 이벤트 리스너 안으로 이동됨)
// if (document.body.classList.contains('cart-page')) { //  <body>에 class="cart-page" 추가 필요
//     renderCartPage();
// }
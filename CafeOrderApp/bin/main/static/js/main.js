document.addEventListener('DOMContentLoaded', () => {
    console.log('New Coffee App Initialized!');

    // Mockup: Update cart count (실제로는 cart.js에서 관리)
    updateCartCountDisplay();

    // 서버에서 상품 목록을 가져와서 렌더링 하는 로직 (예시)
    // fetchProductsAndRender();
});

// 예시: 장바구니 아이콘 카운트 업데이트
function updateCartCountDisplay() {
    const cart = JSON.parse(localStorage.getItem('newCoffeeCart')) || [];
    const cartCountElement = document.getElementById('cart-count');
    if (cartCountElement) {
        let totalItems = 0;
        cart.forEach(item => totalItems += item.quantity);
        cartCountElement.textContent = totalItems;
    }
}

// 예시: 상품 목록을 가져와 렌더링하는 함수 (실제로는 API 호출)
async function fetchProductsAndRender() {
    const productsContainer = document.querySelector('.products-container');
    if (!productsContainer) return;

    // 실제로는 /api/products 와 같은 엔드포인트에서 데이터를 가져옵니다.
    const mockProducts = [
        { id: 1, name: "아메리카노", price: 4500, description: "깊고 진한 풍미", image: "/images/coffee_americano.jpg" },
        { id: 2, name: "카페라떼", price: 5000, description: "부드러운 우유와 조화", image: "/images/coffee_latte.jpg" },
        { id: 3, name: "카푸치노", price: 5000, description: "풍성한 거품", image: "/images/coffee_cappuccino.jpg" },
    ];

    // productsContainer.innerHTML = ''; // 기존 내용 비우기 (Thymeleaf 등으로 서버에서 렌더링 시 불필요)

    mockProducts.forEach(product => {
        const card = document.createElement('div');
        card.classList.add('product-card');
        card.innerHTML = `
            <img src="${product.image}" alt="${product.name}">
            <h3>${product.name}</h3>
            <p class="price">${product.price.toLocaleString()}원</p>
            <p class="description">${product.description}</p>
            <button class="add-to-cart-btn" data-product-id="${product.id}" data-product-name="${product.name}" data-product-price="${product.price}">장바구니 담기</button>
        `;
        // productsContainer.appendChild(card); // Thymeleaf 등으로 서버에서 렌더링 시 불필요
    });

    // 장바구니 담기 버튼 이벤트 리스너 (cart.js로 이동 가능)
    document.querySelectorAll('.add-to-cart-btn').forEach(button => {
        button.addEventListener('click', (event) => {
            const productId = event.target.dataset.productId;
            const productName = event.target.dataset.productName; // 실제로는 id로 상품 정보 조회
            const productPrice = parseFloat(event.target.dataset.productPrice); // 실제로는 id로 상품 정보 조회
            
            // cart.js의 함수 호출
            if (window.addItemToCart) {
                 window.addItemToCart({ id: productId, name: productName, price: productPrice, quantity: 1 });
            } else {
                console.error("cart.js의 addItemToCart 함수를 찾을 수 없습니다.");
            }
        });
    });
}

// 초기 상품 로드 (Thymeleaf로 서버에서 렌더링한다면 이 부분은 필요 없을 수 있습니다)
// fetchProductsAndRender();
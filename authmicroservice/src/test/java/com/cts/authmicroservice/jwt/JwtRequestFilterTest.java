package com.cts.authmicroservice.jwt;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.cts.authmicroservice.service.UserServiceImpl;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.DispatcherType;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;

import org.apache.catalina.connector.Response;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.security.core.userdetails.User;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.context.support.ContextExposingHttpServletRequest;

@ContextConfiguration(classes = {JwtRequestFilter.class})
@WebAppConfiguration
@ExtendWith(SpringExtension.class)
class JwtRequestFilterTest {
    @Autowired
    private JwtRequestFilter jwtRequestFilter;

    @MockBean
    private JwtUtil jwtUtil;

    @MockBean
    private UserServiceImpl userServiceImpl;

    /**
     * Method under test: {@link JwtRequestFilter#doFilterInternal(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, FilterChain)}
     */
    @Test
    void testDoFilterInternal() throws IOException, ServletException {
        MockHttpServletRequest mockHttpServletRequest = new MockHttpServletRequest();
        Response response = new Response();
        FilterChain filterChain = mock(FilterChain.class);
        doNothing().when(filterChain).doFilter((javax.servlet.ServletRequest) any(), (javax.servlet.ServletResponse) any());
        this.jwtRequestFilter.doFilterInternal(mockHttpServletRequest, response, filterChain);
        verify(filterChain).doFilter((javax.servlet.ServletRequest) any(), (javax.servlet.ServletResponse) any());
        assertFalse(mockHttpServletRequest.isRequestedSessionIdFromURL());
        assertTrue(mockHttpServletRequest.isRequestedSessionIdFromCookie());
        assertFalse(mockHttpServletRequest.isAsyncSupported());
        assertFalse(mockHttpServletRequest.isAsyncStarted());
        assertTrue(mockHttpServletRequest.isActive());
        assertTrue(mockHttpServletRequest.getSession() instanceof org.springframework.mock.web.MockHttpSession);
        assertEquals("", mockHttpServletRequest.getServletPath());
        assertEquals(80, mockHttpServletRequest.getServerPort());
        assertEquals("localhost", mockHttpServletRequest.getServerName());
        assertEquals("http", mockHttpServletRequest.getScheme());
        assertEquals("", mockHttpServletRequest.getRequestURI());
        assertEquals(80, mockHttpServletRequest.getRemotePort());
        assertEquals("localhost", mockHttpServletRequest.getRemoteHost());
        assertEquals("127.0.0.1", mockHttpServletRequest.getRemoteAddr());
        assertEquals("HTTP/1.1", mockHttpServletRequest.getProtocol());
        assertEquals("", mockHttpServletRequest.getMethod());
        assertEquals(80, mockHttpServletRequest.getLocalPort());
        assertEquals("localhost", mockHttpServletRequest.getLocalName());
        assertEquals("127.0.0.1", mockHttpServletRequest.getLocalAddr());
        assertTrue(
                mockHttpServletRequest.getInputStream() instanceof org.springframework.mock.web.DelegatingServletInputStream);
        assertEquals(DispatcherType.REQUEST, mockHttpServletRequest.getDispatcherType());
        assertEquals("", mockHttpServletRequest.getContextPath());
        assertEquals(-1L, mockHttpServletRequest.getContentLengthLong());
    }

    /**
     * Method under test: {@link JwtRequestFilter#doFilterInternal(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, FilterChain)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testDoFilterInternal2() throws IOException, ServletException {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at com.cts.authmicroservice.jwt.JwtRequestFilter.doFilterInternal(JwtRequestFilter.java:35)
        //   In order to prevent doFilterInternal(HttpServletRequest, HttpServletResponse, FilterChain)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   doFilterInternal(HttpServletRequest, HttpServletResponse, FilterChain).
        //   See https://diff.blue/R013 to resolve this issue.

        Response response = new Response();
        FilterChain filterChain = mock(FilterChain.class);
        doNothing().when(filterChain).doFilter((javax.servlet.ServletRequest) any(), (javax.servlet.ServletResponse) any());
        this.jwtRequestFilter.doFilterInternal(null, response, filterChain);
    }

    /**
     * Method under test: {@link JwtRequestFilter#doFilterInternal(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, FilterChain)}
     */
    @Test
    void testDoFilterInternal3() throws IOException, ServletException {
        ContextExposingHttpServletRequest contextExposingHttpServletRequest = mock(ContextExposingHttpServletRequest.class);
        when(contextExposingHttpServletRequest.getHeader((String) any())).thenReturn("https://example.org/example");
        Response response = new Response();
        FilterChain filterChain = mock(FilterChain.class);
        doNothing().when(filterChain).doFilter((javax.servlet.ServletRequest) any(), (javax.servlet.ServletResponse) any());
        this.jwtRequestFilter.doFilterInternal(contextExposingHttpServletRequest, response, filterChain);
        verify(contextExposingHttpServletRequest).getHeader((String) any());
        verify(filterChain).doFilter((javax.servlet.ServletRequest) any(), (javax.servlet.ServletResponse) any());
    }

    /**
     * Method under test: {@link JwtRequestFilter#doFilterInternal(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, FilterChain)}
     */
    @Test
    void testDoFilterInternal4() throws IOException, ServletException {
        when(this.userServiceImpl.loadUserByUsername((String) any()))
                .thenReturn(new User("janedoe", "iloveyou", new ArrayList<>()));
        when(this.jwtUtil.validateToken((String) any())).thenReturn(true);
        when(this.jwtUtil.extractUsername((String) any())).thenReturn("janedoe");
        ContextExposingHttpServletRequest contextExposingHttpServletRequest = mock(ContextExposingHttpServletRequest.class);
        when(contextExposingHttpServletRequest.getRemoteAddr()).thenReturn("42 Main St");
        when(contextExposingHttpServletRequest.getSession(anyBoolean())).thenReturn(new MockHttpSession());
        when(contextExposingHttpServletRequest.getHeader((String) any())).thenReturn("Bearer ");
        Response response = new Response();
        FilterChain filterChain = mock(FilterChain.class);
        doNothing().when(filterChain).doFilter((javax.servlet.ServletRequest) any(), (javax.servlet.ServletResponse) any());
        this.jwtRequestFilter.doFilterInternal(contextExposingHttpServletRequest, response, filterChain);
        verify(this.userServiceImpl).loadUserByUsername((String) any());
        verify(this.jwtUtil).validateToken((String) any());
        verify(this.jwtUtil).extractUsername((String) any());
        verify(contextExposingHttpServletRequest).getRemoteAddr();
        verify(contextExposingHttpServletRequest).getHeader((String) any());
        verify(contextExposingHttpServletRequest).getSession(anyBoolean());
        verify(filterChain).doFilter((javax.servlet.ServletRequest) any(), (javax.servlet.ServletResponse) any());
    }

    /**
     * Method under test: {@link JwtRequestFilter#doFilterInternal(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, FilterChain)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testDoFilterInternal5() throws IOException, ServletException {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at com.cts.authmicroservice.jwt.JwtRequestFilter.doFilterInternal(JwtRequestFilter.java:56)
        //   In order to prevent doFilterInternal(HttpServletRequest, HttpServletResponse, FilterChain)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   doFilterInternal(HttpServletRequest, HttpServletResponse, FilterChain).
        //   See https://diff.blue/R013 to resolve this issue.

        when(this.userServiceImpl.loadUserByUsername((String) any())).thenReturn(null);
        when(this.jwtUtil.validateToken((String) any())).thenReturn(true);
        when(this.jwtUtil.extractUsername((String) any())).thenReturn("janedoe");
        ContextExposingHttpServletRequest contextExposingHttpServletRequest = mock(ContextExposingHttpServletRequest.class);
        when(contextExposingHttpServletRequest.getRemoteAddr()).thenReturn("42 Main St");
        when(contextExposingHttpServletRequest.getSession(anyBoolean())).thenReturn(new MockHttpSession());
        when(contextExposingHttpServletRequest.getHeader((String) any())).thenReturn("Bearer ");
        Response response = new Response();
        FilterChain filterChain = mock(FilterChain.class);
        doNothing().when(filterChain).doFilter((javax.servlet.ServletRequest) any(), (javax.servlet.ServletResponse) any());
        this.jwtRequestFilter.doFilterInternal(contextExposingHttpServletRequest, response, filterChain);
    }

    /**
     * Method under test: {@link JwtRequestFilter#doFilterInternal(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, FilterChain)}
     */
    @Test
    void testDoFilterInternal6() throws IOException, ServletException {
        when(this.userServiceImpl.loadUserByUsername((String) any()))
                .thenReturn(new User("janedoe", "iloveyou", new ArrayList<>()));
        when(this.jwtUtil.validateToken((String) any())).thenReturn(false);
        when(this.jwtUtil.extractUsername((String) any())).thenReturn("janedoe");
        ContextExposingHttpServletRequest contextExposingHttpServletRequest = mock(ContextExposingHttpServletRequest.class);
        when(contextExposingHttpServletRequest.getRemoteAddr()).thenReturn("42 Main St");
        when(contextExposingHttpServletRequest.getSession(anyBoolean())).thenReturn(new MockHttpSession());
        when(contextExposingHttpServletRequest.getHeader((String) any())).thenReturn("Bearer ");
        Response response = new Response();
        FilterChain filterChain = mock(FilterChain.class);
        doNothing().when(filterChain).doFilter((javax.servlet.ServletRequest) any(), (javax.servlet.ServletResponse) any());
        this.jwtRequestFilter.doFilterInternal(contextExposingHttpServletRequest, response, filterChain);
        verify(this.userServiceImpl).loadUserByUsername((String) any());
        verify(this.jwtUtil).validateToken((String) any());
        verify(this.jwtUtil).extractUsername((String) any());
        verify(contextExposingHttpServletRequest).getHeader((String) any());
        verify(filterChain).doFilter((javax.servlet.ServletRequest) any(), (javax.servlet.ServletResponse) any());
    }

    /**
     * Method under test: {@link JwtRequestFilter#doFilterInternal(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, FilterChain)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testDoFilterInternal7() throws IOException, ServletException {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at com.cts.authmicroservice.jwt.JwtRequestFilter.doFilterInternal(JwtRequestFilter.java:53)
        //   In order to prevent doFilterInternal(HttpServletRequest, HttpServletResponse, FilterChain)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   doFilterInternal(HttpServletRequest, HttpServletResponse, FilterChain).
        //   See https://diff.blue/R013 to resolve this issue.

        when(this.userServiceImpl.loadUserByUsername((String) any()))
                .thenReturn(new User("janedoe", "iloveyou", new ArrayList<>()));
        when(this.jwtUtil.validateToken((String) any())).thenReturn(null);
        when(this.jwtUtil.extractUsername((String) any())).thenReturn("janedoe");
        ContextExposingHttpServletRequest contextExposingHttpServletRequest = mock(ContextExposingHttpServletRequest.class);
        when(contextExposingHttpServletRequest.getRemoteAddr()).thenReturn("42 Main St");
        when(contextExposingHttpServletRequest.getSession(anyBoolean())).thenReturn(new MockHttpSession());
        when(contextExposingHttpServletRequest.getHeader((String) any())).thenReturn("Bearer ");
        Response response = new Response();
        FilterChain filterChain = mock(FilterChain.class);
        doNothing().when(filterChain).doFilter((javax.servlet.ServletRequest) any(), (javax.servlet.ServletResponse) any());
        this.jwtRequestFilter.doFilterInternal(contextExposingHttpServletRequest, response, filterChain);
    }
}

